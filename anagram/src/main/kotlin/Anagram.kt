class Anagram(private val source: String) {

  private val groupedSource = source.lowercase().groupBy { it }

  fun match(anagrams: Collection<String>): Set<String> {
    return anagrams.filter(::isAnagram).toSet()
  }

  private fun isAnagram(other: String) =
      !other.equals(source, ignoreCase = true) && other.lowercase().groupBy { it } == groupedSource
}
