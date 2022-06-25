class Robot(
    gridPosition: GridPosition = GridPosition(0, 0),
    orientation: Orientation = Orientation.NORTH
) {
  var gridPosition = gridPosition
    private set

  var orientation = orientation
    private set

  fun simulate(instructions: String) {
    instructions.forEach {
      when (it) {
        'L' -> turnLeft()
        'R' -> turnRight()
        'A' -> advance()
      }
    }
  }

  private fun turnLeft() {
    orientation = orientation.rotate(false)
  }

  private fun turnRight() {
    orientation = orientation.rotate(true)
  }

  private fun Orientation.rotate(isClockwise: Boolean) =
      // cycle through the enum values in the appropriate direction
      generateSequence { Orientation.values().run { if (isClockwise) toList() else reversed() } }
          .flatten()
          // drop before current
          .dropWhile { it != this }
          // find the next value in the sequence
          .elementAt(1)

  private fun advance() {
    gridPosition =
        when (orientation) {
          Orientation.NORTH -> gridPosition.run { copy(y = y.inc()) }
          Orientation.EAST -> gridPosition.run { copy(x = x.inc()) }
          Orientation.SOUTH -> gridPosition.run { copy(y = y.dec()) }
          Orientation.WEST -> gridPosition.run { copy(x = x.dec()) }
        }
  }
}
