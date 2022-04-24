object HandshakeCalculator {
  fun calculateHandshake(number: Int): List<Signal> {
    val signals = Signal.values().filter { number hasBitSet it.ordinal }

    return if (number hasBitSet Signal.values().size) signals.reversed()
    else signals
  }

  private infix fun Int.hasBitSet(n: Int): Boolean = this shr n and 1 == 1
}
