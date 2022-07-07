object SpiralMatrix {
  private val dir = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

  fun ofSize(size: Int): Array<IntArray> {
    if (size == 0) return emptyArray()
    return (1..size * size)
        .fold(Array(size) { IntArray(size) } to ((0 to 0) to 0)) { (matrix, xyd), i ->
          val (xy, di) = xyd
          val (x, y) = xy
          matrix[x][y] = i

          val nx = x + dir[di].first
          val ny = y + dir[di].second

          if (nx in 0 until size && ny in 0 until size && matrix[nx][ny] == 0) {
            (matrix to ((nx to ny) to (di)))
          } else {
            (di.inc() % dir.size).let { (matrix to ((x + dir[it].first to y + dir[it].second) to it)) }
          }
        }
        .first
  }
}
