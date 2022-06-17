object Yacht {
  fun solve(category: YachtCategory, vararg dices: Int) =
      when (category) {
        YachtCategory.YACHT -> dices.distinct().let { if (it.size == 1) 50 else 0 }
        YachtCategory.FULL_HOUSE ->
            dices.groupBy { it }.values.let {
              if (it.size == 2 && it.any { it.size == 3 }) dices.sum() else 0
            }
        YachtCategory.FOUR_OF_A_KIND ->
            (dices.groupBy { it }.values.firstOrNull { it.size >= 4 }?.get(0) ?: 0) * 4
        YachtCategory.LITTLE_STRAIGHT ->
            dices.distinct().let { if (it.size == 5 && 6 !in it) 30 else 0 }
        YachtCategory.BIG_STRAIGHT ->
            dices.distinct().let { if (it.size == 5 && 1 !in it) 30 else 0 }
        YachtCategory.CHOICE -> dices.sum()
        else -> dices.count { it == category.ordinal } * category.ordinal
      }
}
