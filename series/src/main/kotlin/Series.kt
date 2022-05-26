object Series {

  fun slices(n: Int, s: String): List<List<Int>> {
    require(s.length >= n) { "Slice size must be smaller than series length" }

    return s.map(Char::digitToInt).windowed(n, 1)
  }
}
