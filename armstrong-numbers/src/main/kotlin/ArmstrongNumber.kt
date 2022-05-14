object ArmstrongNumber {

  fun check(input: Int): Boolean {
    return "$input".run {
      sumOf { it.digitToInt().pow(length) }
    } == input
  }

  private fun Int.pow(n: Int) = generateSequence { this }.take(n).reduce(Int::times)
}
