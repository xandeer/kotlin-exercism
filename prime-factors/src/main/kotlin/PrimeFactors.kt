object PrimeFactorCalculator {

  fun primeFactors(int: Int): List<Int> {
    return primeFactors(int.toLong()).map { it.toInt() }
  }

  private val primes =
      generateSequence(2L) { pre ->
        when (pre) {
          2L -> 3
          else -> pre + 2
        }
      }
          .filter { i -> (2 until i / 2).none { i % it == 0L } }

  tailrec fun primeFactors(n: Long, acc: List<Long> = listOf()): List<Long> {
    if (n == 1L) return acc
    val factor = primes.first { n % it == 0L }
    return primeFactors(n / factor, acc + factor)
  }
}
