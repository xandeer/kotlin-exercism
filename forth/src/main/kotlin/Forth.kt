class Forth {

  fun evaluate(vararg line: String): List<Int> {
    val stack = ArrayDeque<Int>()

    line.map { it.lowercase() }.let(::handleExpressions).first().split(" ").forEach {
      when (it) {
        "+", "-", "*", "/", "swap", "over" -> {
          val a = stack.removeLastOrNull() ?: throw IllegalArgumentException("empty stack")
          val b =
              stack.removeLastOrNull()
                  ?: throw IllegalArgumentException("only one value on the stack")
          when (it) {
            "swap" -> stack.addAll(listOf(a, b))
            "over" -> stack.addAll(listOf(b, a, b))
            else -> stack.addLast(b.toInt().applyOperation(it, a.toInt()))
          }
        }
        "dup", "drop" ->
            stack.removeLastOrNull()?.let { a -> if (it == "dup") stack.addAll(listOf(a, a)) }
                ?: throw IllegalArgumentException("empty stack")
        else ->
            if (it.all { it.isDigit() }) stack.addLast(it.toInt())
            else throw IllegalArgumentException("undefined operation")
      }
    }

    return stack.toList()
  }

  private tailrec fun handleExpressions(stack: List<String>): List<String> {
    val (name, value) =
        stack.firstOrNull()?.let {
          if (": \\d+ .+ ;".toRegex().matches(it))
              throw IllegalArgumentException("illegal operation")

          getDef(it)
        }
            ?: return stack

    return if (stack.size > 1) {
      var isOverride = false
      val rest =
          stack.drop(1).map {
            if (isOverride) it
            else if (": $name .* ;".toRegex().matches(it)) {
              isOverride = true
              getDef(it)?.let { (_, newValue) -> ": $name ${newValue.replace(name, value)} ;" }
                  ?: it
            } else it.replace(name, value)
          }
      handleExpressions(rest)
    } else stack
  }

  private fun getDef(str: String) =
      ": ([a-z+*/-]+) (.*) ;".toRegex().find(str)?.groupValues?.drop(1)

  private fun Int.applyOperation(operation: String, b: Int): Int =
      when (operation) {
        "+" -> this + b
        "-" -> this - b
        "*" -> this * b
        else -> if (b != 0) this / b else throw IllegalArgumentException("divide by zero")
      }
}
