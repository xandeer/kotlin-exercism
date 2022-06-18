object Sieve {

  fun primesUpTo(upperBound: Int): List<Int> = sieve((2..upperBound).toList())

  private tailrec fun sieve(rest: List<Int>, primes: List<Int> = emptyList()): List<Int> =
      if (rest.isEmpty()) primes
      else
          sieve(
              rest.drop(1) - rest.map { it * rest.first() }.takeWhile { it <= rest.last() },
              primes + rest.first()
          )
}
