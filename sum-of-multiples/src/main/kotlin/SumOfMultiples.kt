object SumOfMultiples {

  fun sumFilter(factors: Set<Int>, limit: Int): Int =
      (1..limit.dec())
          .takeWhile { it < limit }
          .filter { (factors - 0).any { f -> it % f == 0 } }
          .sum()

  fun sum(factors: Set<Int>, limit: Int): Int =
      (factors - 0).flatMap { 0 until limit step it }.distinct().sum()
}
