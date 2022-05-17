class IsbnVerifier {

  fun isValid(number: String): Boolean {
    if (!("[0-9-]+[0-9X]".toRegex().matches(number))) return false

    val seq = "[0-9X]".toRegex().findAll(number).map { it.value }.toList()

    if (seq.size != 10) return false

    return seq.map { if (it == "X") 10 else it.toInt() }
      .zip(10 downTo 1).map { it.first * it.second }.sum() % 11 == 0
  }
}
