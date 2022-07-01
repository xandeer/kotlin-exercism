data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
  operator fun plus(other: ComplexNumber): ComplexNumber {
    return ComplexNumber(real + other.real, imag + other.imag)
  }

  operator fun minus(other: ComplexNumber): ComplexNumber {
    return ComplexNumber(real - other.real, imag - other.imag)
  }

  operator fun times(other: ComplexNumber): ComplexNumber {
    return ComplexNumber(
        real * other.real - imag * other.imag,
        real * other.imag + imag * other.real
    )
  }

  operator fun div(other: ComplexNumber): ComplexNumber {
    return ComplexNumber(
        (real * other.real + imag * other.imag) /
            (other.real * other.real + other.imag * other.imag),
        (imag * other.real - real * other.imag) /
            (other.real * other.real + other.imag * other.imag)
    )
  }

  val abs: Double
    get() = Math.sqrt(real * real + imag * imag)

  fun conjugate(): ComplexNumber {
    return ComplexNumber(real, -imag)
  }
}

fun exponential(z: ComplexNumber): ComplexNumber {
  val exp = Math.exp(z.real)
  return ComplexNumber(exp * Math.cos(z.imag), exp * Math.sin(z.imag))
}
