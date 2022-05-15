import kotlin.math.pow

object ResistorColorTrio {

  fun text(vararg input: Color): String {
    val number = input.take(2).joinToString("") { "${it.ordinal}" } +
    "0".repeat(input.last().ordinal)
    
    val level = number.length.dec() / 3
    val trimmed = number.toInt() / 1_000.0.pow(level)
    val unit = Unit.values()[level].name.lowercase()

    return "${trimmed.toInt()} $unit"
  }
}
