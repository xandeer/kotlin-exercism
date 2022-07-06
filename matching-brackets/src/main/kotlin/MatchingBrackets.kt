object MatchingBrackets {

  private val brackets = mapOf('{' to '}', '[' to ']', '(' to ')')

  fun isValid(input: String): Boolean {
    return input
        .fold(listOf<Char>()) { stack, c ->
          when (c) {
            in brackets.keys -> stack + c
            in brackets.values -> {
              if (stack.isEmpty()) return false
              if (brackets[stack.last()] != c) return false
              stack.dropLast(1)
            }
            else -> stack
          }
        }
        .isEmpty()
  }
}
