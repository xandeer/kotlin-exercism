object Bob {
  fun hey(input: String): String {
    return input.trim().let {
      when {
        it.isEmpty() -> "Fine. Be that way!"
        it.isAllCapital() && it.isQuestion() -> "Calm down, I know what I'm doing!"
        it.isQuestion() -> "Sure."
        it.isAllCapital() -> "Whoa, chill out!"
        else -> "Whatever."
      }
    }
  }

  private fun String.isAllCapital() = filter(Char::isLetter).run { isNotEmpty() && all(Char::isUpperCase) }

  private fun String.isQuestion() = endsWith('?')
}
