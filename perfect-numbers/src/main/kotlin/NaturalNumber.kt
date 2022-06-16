enum class Classification {
  DEFICIENT,
  PERFECT,
  ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
  require(naturalNumber > 0) { "Classification is only defined for natural numbers." }

  return (1..naturalNumber / 2).filter { naturalNumber % it == 0 }.sum().let {
    when {
      it > naturalNumber -> Classification.ABUNDANT
      it < naturalNumber -> Classification.DEFICIENT
      else -> Classification.PERFECT
    }
  }
}
