object RunLengthEncoding {

  fun encodeFor(input: String): String {
    val encoded = StringBuilder()
    var count = 0
    var lastChar = ' '
    for (char in input) {
      if (char == lastChar) {
        count++
      } else {
        if (count > 1) {
          encoded.append(count)
        }

        if (count > 0) {
          encoded.append(lastChar)
        }
        count = 1
        lastChar = char
      }
    }

    if (count > 1) {
      encoded.append(count)
    }
    if (count > 0) {
      encoded.append(lastChar)
    }

    return encoded.toString()
  }

  fun decodeFor(input: String): String {
    val decoded = StringBuilder()
    var count = 0
    for (char in input) {
      if (char.isDigit()) {
        count = count * 10 + char.digitToInt()
      } else {
        if (count == 0) {
          decoded.append(char)
        } else {
          decoded.append(char.toString().repeat(count))
        }
        count = 0
      }
    }
    return decoded.toString()
  }

  fun encode(input: String) = input.replace(Regex("(.)\\1+")) {
    "${it.value.length}${it.groupValues[1]}"
  }

  fun decode(input: String) = input.replace(Regex("(\\d+)(.)")) {
    it.groupValues[2].repeat(it.groupValues[1].toInt())
  }
}
