class KindergartenGarden(private val diagram: String) {

  private val students =
      listOf(
          "Alice",
          "Bob",
          "Charlie",
          "David",
          "Eve",
          "Fred",
          "Ginny",
          "Harriet",
          "Ileana",
          "Joseph",
          "Kincaid",
          "Larry"
      )

  private val plants = mapOf('C' to "clover", 'G' to "grass", 'R' to "radishes", 'V' to "violets")

  fun getPlantsOfStudent(student: String): List<String> =
      students.indexOf(student).let { index ->
        require(index != -1) { "Unknown student: $student" }

        diagram.lines().map { it.chunked(2) }.map { it[index] }.joinToString("").map {
          plants[it] ?: throw IllegalArgumentException("Unknown plant: $it")
        }
      }
}
