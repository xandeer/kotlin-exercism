class Deque<T> {
  private var list = listOf<T>()

  fun push(value: T) {
    list += listOf(value)
  }

  fun pop(): T? {
    return list.let {
      list = it.dropLast(1)
      it.lastOrNull()
    }
  }

  fun unshift(value: T) {
    list = listOf(value) + list
  }

  fun shift(): T? {
    return list.let {
      list = it.drop(1)
      it.firstOrNull()
    }
  }
}
