import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond(private val ldt: LocalDateTime) {
  constructor(ld: LocalDate): this(ld.atStartOfDay())

  val date: LocalDateTime = ldt.plusSeconds(1e9.toLong())
}
