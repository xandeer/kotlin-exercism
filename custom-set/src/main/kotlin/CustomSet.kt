class CustomSet {
  private val set = mutableSetOf<Int>()

  constructor(elements: Collection<Int>) {
    set.addAll(elements)
  }

  constructor(vararg elements: Int): this(elements.toList())

  fun isEmpty(): Boolean {
    return set.isEmpty()
  }

  fun isSubset(other: CustomSet): Boolean {
    return other.set.containsAll(set)
  }

  fun isDisjoint(other: CustomSet): Boolean {
    return set.intersect(other.set).isEmpty()
  }

  fun contains(other: Int): Boolean {
    return set.contains(other)
  }

  fun intersection(other: CustomSet): CustomSet {
    return CustomSet(set.intersect(other.set))
  }

  fun add(other: Int) {
    set.add(other)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as CustomSet

    if (set != other.set) return false

    return true
  }

  operator fun plus(other: CustomSet): CustomSet {
    return CustomSet(set.union(other.set))
  }

  operator fun minus(other: CustomSet): CustomSet {
    return CustomSet(set.minus(other.set))
  }
}
