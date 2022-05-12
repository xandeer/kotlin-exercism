object BeerSong {
  fun verses(startBottles: Int, takeDown: Int) =
    (startBottles downTo takeDown).map(::verse).joinToString("\n")

  private fun verse(n: Int) = n.inventory() + n.afterTaking()

  private fun Int.inventory() = bottles().let { "${it.onTheWall()}, ${it.lowercase().beer()}.\n"}

  private fun String.onTheWall() = "${this.beer()} on the wall"

  private fun String.beer() = "$this of beer"

  private fun Int.bottles() = "${if (this == 0) "No more" else this} bottle${if (this != 1) "s" else ""}"

  private fun Int.afterTaking() = when (this) {
    0 -> "Go to the store and buy some more"
    1 -> "Take it down and pass it around"
    else -> "Take one down and pass it around"
  } + ", ${(if (this == 0) 99 else this.dec()).bottles().lowercase().onTheWall()}.\n"
}
