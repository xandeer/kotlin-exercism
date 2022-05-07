object PigLatin {

  fun translate(phrase: String): String {
    return phrase.split(" ").map(::translateWord).joinToString(" ")
  }

  private val r1 = "([aeiou]|xr|yt)(.+)".toRegex()
  private val r2 = "([^aeiou]+)(y.+)".toRegex()
  private val r3 = "(s?qu|[^aeiou]+)(.+)".toRegex()

  private fun translateWord(word: String): String {
    return when {
      word.matches(r1) -> word + "ay"
      word.matches(r2) -> word.replace(r2, "$2$1ay")
      word.matches(r3) -> word.replace(r3, "$2$1ay")
      else -> word
    }
  }
}
