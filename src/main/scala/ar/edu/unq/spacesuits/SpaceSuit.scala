package ar.edu.unq.spacesuits

abstract class SpaceSuit {
  var oxygen: Double

  def walkConsume(kms: Int): Double
  def weightConsume(kms: Int, weight: Double) = kms * weight / Math.sqrt(kms)
  def walk(kms: Int, weight: Double = 0.0): Unit = {
    val consumed = walkConsume(kms) + weightConsume(kms, weight)
    oxygen = Math.max(0, oxygen - consumed)
  }
}

class LightSpaceSuit extends SpaceSuit {
  var oxygen = 1500.0
  override def walkConsume(kms: Int) = Math.min(10, kms * 0.15)
}

class HeavySpaceSuit extends SpaceSuit {
  var oxygen = 4000.0
  override def walkConsume(kms: Int) = kms * 0.20 - 10.0
}