object Prime {
  private val primes = generateSequence(2, Int::inc).filter(::isPrime)

  private fun isPrime(n: Int): Boolean = (2..n / 2).none { n % it == 0 }

  fun nth(n: Int): Int {
    require(n > 0) { "There is no zeroth prime." }
    return primes.take(n).last()
  }
}
