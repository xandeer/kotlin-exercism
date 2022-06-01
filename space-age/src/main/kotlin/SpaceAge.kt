import kotlin.math.roundToInt

class SpaceAge(private val seconds: Long) {

  companion object {
    private const val EARTH_YEAR_IN_SECONDS = 31557600
  }

  fun onEarth(): Double = onEarth(1.0)

  private fun onEarth(planet: Double): Double = (seconds / (EARTH_YEAR_IN_SECONDS * planet)).roundTo(2)

  private fun Double.roundTo(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return (this * multiplier).roundToInt() / multiplier
  }

  fun onMercury(): Double = onEarth(0.2408467)

  fun onVenus(): Double = onEarth(0.61519726)

  fun onMars(): Double = onEarth(1.8808158)

  fun onJupiter(): Double = onEarth(11.862615)

  fun onSaturn(): Double = onEarth(29.447498)

  fun onUranus(): Double = onEarth(84.016846)

  fun onNeptune(): Double = onEarth(164.79132)
}
