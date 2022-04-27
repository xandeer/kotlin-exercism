object Flattener {
  fun flatten(source: Collection<Any?>): List<Any> {
    // return mutableListOf<Any>().apply {
    //   source.forEach {
    //     if (it is Collection<*>) {
    //       addAll(flatten(it))
    //     } else {
    //       it?.let { add(it) }
    //     }
    //   }
    // }
    return source.flatMap {
      if (it is Collection<*>) flatten(it)
      else listOf(it)
    }.filterNotNull()
  }
}
