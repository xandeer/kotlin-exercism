object Isogram {

  fun isIsogram(input: String): Boolean {
    // return input.lowercase()
    //   .filter(Char::isLetter)
    //   .groupingBy { it }
    //   .eachCount()
    //   .values
    //   .all { it == 1 }

    return input.lowercase().filter(Char::isLetter).let { it.toSet().size == it.length }
  }
}
