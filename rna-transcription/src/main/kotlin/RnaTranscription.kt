private val dict = "CGTA".zip("GCAU").toMap()

fun transcribeToRna(dna: String): String = dna.map { dict[it] }.joinToString("")
