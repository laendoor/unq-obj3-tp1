package ar.edu.unq.suits

class Suit extends LightSuit {

  def weightConsume(kms: Int, weight: Double) = kms * weight / Math.sqrt(kms)

  def walk(kms: Int, weight: Double = 0.0): Unit = {
    val consumed = walkConsume(kms) + weightConsume(kms, weight)
    oxygen = Math.max(0, oxygen - consumed)
  }
}