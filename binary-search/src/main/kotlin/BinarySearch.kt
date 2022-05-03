object BinarySearch {
  fun <T : Comparable<T>> search(list: List<T>, item: T) = search(list, item, 0)

  tailrec private fun <T : Comparable<T>> search(list: List<T>, item: T, index: Int): Int {
    val mi = list.size / 2
    return when {
      list.isEmpty() -> throw NoSuchElementException("Nothing is found in $list with $item.")
      list[mi] == item -> mi + index
      list[mi] < item -> search(list.drop(mi.inc()), item, mi.inc() + index)
      else -> search(list.take(mi), item, index)
    }
  }
}
