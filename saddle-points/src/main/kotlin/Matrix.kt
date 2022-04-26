data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val rows: List<List<Int>>) {
  private val columns by lazy { rows[0].indices.map { i -> rows.map { it[i] } } }
  private val maxInRow by lazy { rows.map { it.maxOrNull() } }
  private val minInColumn by lazy { columns.map { it.minOrNull() } }

  val saddlePoints: Set<MatrixCoordinate> get() =
    rows.mapIndexed { rowIndex, row ->
      row.mapIndexedNotNull { colIndex, _ ->
        if (maxInRow[rowIndex] == minInColumn[colIndex]) {
          MatrixCoordinate(rowIndex.inc(), colIndex.inc())
        } else null
      }
    }.flatten().toSet()
}
