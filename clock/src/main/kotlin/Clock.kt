class Clock(hour: Int, minute: Int) {
  companion object {
    private const val MINUTES_IN_HOUR = 60
    private const val MINUTES_IN_DAY = 24 * MINUTES_IN_HOUR
  }

  private var minutes: Int = 0
    set(v) {
      field = (v % MINUTES_IN_DAY + MINUTES_IN_DAY) % MINUTES_IN_DAY
    }

  init {
    minutes = hour * MINUTES_IN_HOUR + minute
  }

  fun subtract(minutes: Int) {
    this.minutes -= minutes
  }

  fun add(minutes: Int) {
    this.minutes += minutes
  }

  override fun toString(): String {
    return "%02d:%02d".format(minutes / MINUTES_IN_HOUR, minutes % MINUTES_IN_HOUR)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Clock

    return minutes == other.minutes
  }
}
