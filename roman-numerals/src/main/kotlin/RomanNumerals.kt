object RomanNumerals {

  fun value(n: Int): String {
    return value(n, "")
  }

  private tailrec fun value(n: Int, acc: String): String {
    return when {
      n >= 1000 -> value(n - 1000, acc + "M")
      n >= 900 -> value(n - 900, acc + "CM")
      n >= 500 -> value(n - 500, acc + "D")
      n >= 400 -> value(n - 400, acc + "CD")
      n >= 100 -> value(n - 100, acc + "C")
      n >= 90 -> value(n - 90, acc + "XC")
      n >= 50 -> value(n - 50, acc + "L")
      n >= 40 -> value(n - 40, acc + "XL")
      n >= 10 -> value(n - 10, acc + "X")
      n == 9 -> value(n - 9, acc + "IX")
      n >= 5 -> value(n - 5, acc + "V")
      n == 4 -> value(n - 4, acc + "IV")
      n >= 1 -> value(n - 1, acc + "I")
      else -> acc
    }
  }
}
