class BaseConverter(private val base: Int, private val digits: IntArray) {

  init {
    require(base > 1) { "Bases must be at least 2." }
    require(digits.none { it < 0 }) { "Digits may not be negative." }
    require(digits.all { it < base }) { "All digits must be strictly less than the base." }
    require(digits.isNotEmpty()) { "You must supply at least one digit." }
    require(digits.takeWhile { it == 0 }.let { digits.size == 1 || it.isEmpty() }) {
      "Digits may not contain leading zeros."
    }
  }

  fun convertToBase(newBase: Int): IntArray {
    require(newBase >= 2) { "Bases must be at least 2." }
    return toDecimal(digits).let { it.decimalTo(newBase) }
  }

  private fun toDecimal(number: IntArray): Int {
    return number.fold(0) { acc, digit -> acc * base + digit }
  }

  private fun Int.decimalTo(newBase: Int): IntArray {
    return if (this < newBase) intArrayOf(this)
    else (this / newBase).decimalTo(newBase) + this % newBase
  }
}
