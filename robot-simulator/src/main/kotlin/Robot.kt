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
    orientation = when (orientation) {
      Orientation.NORTH -> Orientation.WEST
      Orientation.WEST -> Orientation.SOUTH
      Orientation.SOUTH -> Orientation.EAST
      Orientation.EAST -> Orientation.NORTH
    }
  }

  private fun turnRight() {
    orientation = when (orientation) {
      Orientation.NORTH -> Orientation.EAST
      Orientation.EAST -> Orientation.SOUTH
      Orientation.SOUTH -> Orientation.WEST
      Orientation.WEST -> Orientation.NORTH
    }
  }

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
