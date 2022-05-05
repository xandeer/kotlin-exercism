object Raindrops {
  private val sounds = arrayOf(3, 5, 7)
    .zip(arrayOf("Pling", "Plang", "Plong"))
    .toMap()

  fun convert(n: Int): String {
    // return sounds.filterKeys { n % it == 0 }
      // .values
      // .joinToString("")
      // .takeIf { it.isNotEmpty() } ?: n.toString()

    return buildString {
      sounds.forEach { factor, sound ->
        if (n % factor == 0) append(sound)
      }
      if (isEmpty()) append(n)
    }
  }
}
