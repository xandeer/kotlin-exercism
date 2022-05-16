object Transpose {

  fun transpose(input: List<String>): List<String> {
    if (input.isEmpty()) return emptyList()

    val padded = input.mapIndexed { i, s ->
      s.padEnd(input.drop(i).maxOf { it.length }, ' ')
    }
    return (0 until input.maxOf { it.length }).map { i ->
      padded.map { it.getOrNull(i) }.filterNotNull().joinToString("")
    }
  }
}
