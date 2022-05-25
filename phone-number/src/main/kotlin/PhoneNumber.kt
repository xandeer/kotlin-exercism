class PhoneNumber(input: String) {

  val number: String? = input.filter(Character::isDigit).dropWhile { it == '1' }.let {
      require(it.length == 10)
      require(arrayOf(it[0], it[3]).all { it !in "01" })

      it
    }
}
