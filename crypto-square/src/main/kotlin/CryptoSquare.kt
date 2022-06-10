import kotlin.math.sqrt
import kotlin.math.ceil

object CryptoSquare {
  fun ciphertext(plaintext: String): String {
    return plaintext.lowercase().filter(Char::isLetterOrDigit).let { normalized ->
      if (normalized.isEmpty()) ""
      else ceil(sqrt(normalized.length.toDouble())).toInt().let { size ->
        normalized.chunked(size).let { chunks ->
          (0 until size).joinToString(" ") { i ->
            chunks.map { it.getOrElse(i) { ' ' } }.joinToString("")
          }
        }
      }
    }
  }
}
