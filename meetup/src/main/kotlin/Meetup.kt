import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {
  fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
    return (1..LocalDate.of(year, month, 1).lengthOfMonth())
      .map { LocalDate.of(year, month, it) }
      .filter { it.dayOfWeek == dayOfWeek }.let {
        when (schedule) {
          MeetupSchedule.LAST -> it.last()
          MeetupSchedule.TEENTH -> it.first { it.dayOfMonth in 13..19 }
          else -> it[schedule.ordinal]
        }
      }
  }
}
