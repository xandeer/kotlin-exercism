class DiamondPrinter {

  fun printToList(end: Char) = ('A'..end).map { row(it, end) }.let {
    it + it.reversed().drop(1)
  }

  private fun row(n: Char, e: Char) = rightHalf(n, e).let {
    it.drop(1).reversed() + it
  }

  private fun rightHalf(b: Char, e: Char) = buildString {
    ('A'..e).forEach { append(if (b == it) b else ' ') }
  }
}
