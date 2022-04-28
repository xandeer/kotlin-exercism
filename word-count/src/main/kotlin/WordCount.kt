object WordCount {
  fun phrase(phrase: String): Map<String, Int> {
    return phrase.lowercase()
      .split("[^a-z0-9']|\\B'|'\\B".toRegex())
      .filter(String::isNotEmpty)
      .groupingBy { it }
      .eachCount()
  }
}
