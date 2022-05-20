class Dna(private val nucleotides: String) {

  init {
    require(nucleotides.all { it in "ACGT" }) { "Invalid nucleotide in: $nucleotides" }
  }

  val nucleotideCounts = ("ACGT" + nucleotides).groupBy { it }.mapValues { it.value.size.dec() }
}
