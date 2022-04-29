class Robot {

  var name: String = generateName()
  private set

  fun reset() {
    name = reset(name)
  }

  companion object {
    private val names = mutableSetOf<String>()

    private tailrec fun generateName(): String {
      val name = getRandomName()
      return if (names.add(name)) name
      else generateName()
    }

    private fun reset(name: String): String {
      names.remove(name)
      return generateName()
    }

    private fun getRandomName() = random(('A'..'Z'), 2) + random(('0'..'9'), 3)

    private fun random(range: CharRange, length: Int) =
      (1..length).map { range.random() }.joinToString("")
  }
}
