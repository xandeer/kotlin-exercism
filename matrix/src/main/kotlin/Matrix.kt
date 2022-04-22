class Matrix(private val matrixAsString: String) {
  private val matrix = matrixAsString.lines()
    .map { it.trim().split("\\s+".toRegex()).map(String::toInt) }

  fun column(colNr: Int): List<Int> {
    return matrix.map { it[colNr - 1] }
  }

  fun row(rowNr: Int): List<Int> {
    return matrix[rowNr - 1]
  }
}
