object PigLatin {

  fun translate(phrase: String): String {
    return phrase.split(" ").map(::translateWord).joinToString(" ")
  }

  private val rxs = arrayOf(
    "([aeiou]|xr|yt)(.+)",
    "([^aeiou]+)(y.+)",
    "(s?qu|[^aeiou]+)(.+)",
    ".+")
    .map(String::toRegex)
    .zip(arrayOf("$0ay", "$2$1ay", "$2$1ay", "$0"))

  private fun translateWord(word: String): String {
    return rxs.first { (rx, _) -> word.matches(rx) }
      .let { (regex, replacement) -> word.replace(regex, replacement) }
  }
}
