class RotationalCipher(private val shift: Int) {

  private val key = buildKey('a'..'z') + buildKey('A'..'Z')

  fun encode(text: String): String {
    return text.map { key[it] ?: it }.joinToString("")
  }

  private fun buildKey(chars: CharRange) =
    chars.zip(chars.drop(shift) + chars.take(shift)).toMap()
}
