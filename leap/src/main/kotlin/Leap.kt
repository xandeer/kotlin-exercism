data class Year(val year: Int) {

  val isLeap: Boolean = year.isDivisibleBy(400) || (!year.isDivisibleBy(100) && year.isDivisibleBy(4))

  private fun Int.isDivisibleBy(m: Int): Boolean = this % m == 0
}
