object Acronym {
  fun generate(phrase: String) : String {
    return "[a-zA-Z']+".toRegex().findAll(phrase).map {
      it.value.first().uppercase()
    }.joinToString("")
  }
}
