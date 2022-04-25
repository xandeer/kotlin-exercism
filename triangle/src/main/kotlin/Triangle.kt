class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    private val distinctCount = listOf(a, b, c).distinct().size

    init {
      val sides = listOf(a, b, c).map(Number::toDouble).sorted()
      require(sides.last() < sides.dropLast(1).sum() && sides.first() > 0)
    }

    val isEquilateral: Boolean get() = distinctCount == 1
    val isIsosceles: Boolean get() = distinctCount < 3
    val isScalene: Boolean get() = distinctCount == 3
}
