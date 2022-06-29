object PascalsTriangle {

  fun computeTriangleFor(rows: Int): List<List<Int>> {
    return mutableListOf<List<Int>>().apply {
      for (i in 1..rows) {
        (1..i).map { if (it == 1 || it == i) 1 else get(i - 2)[it - 1] + get(i - 2)[it - 2] }.let {
          add(it)
        }
      }
    }
  }

  fun computeTriangle(rows: Int): List<List<Int>> {
    return generateSequence(listOf(1)) { prev ->
          listOf(1) + prev.windowed(2).map { it.sum() } + listOf(1)
        }
        .take(rows)
        .toList()
  }
}
