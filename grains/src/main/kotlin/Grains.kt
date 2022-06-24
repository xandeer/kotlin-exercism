import java.math.BigInteger

object Board {
  private val squareNum = 64

  fun getGrainCountForSquare(number: Int): BigInteger {
    require(number in 1..squareNum) { "Square must be between 1 and 64" }

    return BigInteger.ONE.shiftLeft(number - 1)
    // return BigInteger.valueOf(2).pow(number - 1)
  }

  // 2^0 + 2^1 + 2^2 + ... + 2^63 = 2^64 - 1
  fun getTotalGrainCount(): BigInteger {
    return BigInteger.ONE.shiftLeft(squareNum).subtract(BigInteger.ONE)
    // return BigInteger.valueOf(2).pow(squareNum) - BigInteger.ONE
  }
}
