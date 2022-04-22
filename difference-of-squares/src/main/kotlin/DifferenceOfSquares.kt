class Squares(private val n: Int) {

  // fun sumOfSquares() = n * (n + 1) * (2 * n + 1) / 6
  // fun squareOfSum() = (n * (n + 1) / 2).square()

  fun sumOfSquares() = (1..n).sumOf(Int::square)
  fun squareOfSum() = (1..n).sum().square()

  fun difference() = squareOfSum() - sumOfSquares()
}

fun Int.square() = this * this
