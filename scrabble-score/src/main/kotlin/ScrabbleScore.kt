object ScrabbleScore {

  fun scoreLetter(c: Char): Int {
    return when (c) {
      in "dg"-> 2
      in "bcmp"-> 3
      in "fhvwy" -> 4
      'k' -> 5
      in "jx" -> 8
      in "qz" -> 10
      else -> 1
    }
  }

  fun scoreWord(word: String): Int {
    return word.lowercase()
      .sumBy(::scoreLetter)
      // .map(::scoreLetter).sum()
  }
}
