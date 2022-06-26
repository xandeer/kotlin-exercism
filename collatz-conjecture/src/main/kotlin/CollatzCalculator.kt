object CollatzCalculator {
  fun computeStepCount(start: Int): Int {
    require(start > 0) { "Only positive numbers are allowed" }

    // return computeStepCount(start, 0)
    return sequenceCount(start)
  }

  private tailrec fun computeStepCount(start: Int, step: Int): Int =
      when {
        start == 1 -> step
        start % 2 == 0 -> computeStepCount(start / 2, step + 1)
        else -> computeStepCount(start * 3 + 1, step + 1)
      }

  private fun collazStep(n: Int) = if (n and 1 == 0) n / 2 else 3 * n + 1

  private fun sequenceCount(start: Int) =
      generateSequence(start, ::collazStep).takeWhile { it > 1 }.count()
}
