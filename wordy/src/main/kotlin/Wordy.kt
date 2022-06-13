object Wordy {
  private val operRe = " (plus|minus|multiplied by|divided by) (-?\\d+)"
  private val exprRe = "What is (-?\\d+)((?:$operRe)*)\\?"

  fun answer(input: String): Int {
    return exprRe.toRegex().find(input)?.let {
      val (num, ops) = it.destructured
      operRe.toRegex().findAll(ops).map { it.destructured }.fold(num.toInt()) { acc, (op, operand) ->
        when (op) {
          "plus" -> acc + operand.toInt()
          "minus" -> acc - operand.toInt()
          "multiplied by" -> acc * operand.toInt()
          "divided by" -> acc / operand.toInt()
          else -> throw IllegalArgumentException("Unknown operator: $op")
        }
      }
    } ?: throw IllegalArgumentException("Invalid input")
  }
}
