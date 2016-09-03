package ar.edu.unq.spacesuits

abstract class SpaceSuit {
  var oxygen: Double = 0.0
  def walk(kms: Int, weight: Double = 0.0): Unit
  def restoreOxygen(): Unit
  protected def consumed(amount: Double): Unit = {
    oxygen = Math.max(0, oxygen - amount)
  }
  protected def extraConsume(kms: Int, weight: Double): Double = {
    kms * weight / Math.sqrt(kms)
  }
}

class LightSpaceSuit extends SpaceSuit {

  restoreOxygen()

  override def restoreOxygen(): Unit = oxygen = 1500.0
  override def walk(kms: Int, weight: Double): Unit = {
    consumed(Math.min(10, kms * 0.15) + extraConsume(kms, weight))
  }

}

class HeavySpaceSuit extends SpaceSuit {

  restoreOxygen()

  override def restoreOxygen(): Unit = oxygen = 4000.0
  override def walk(kms: Int, weight: Double): Unit = {
    consumed(kms * 0.20 + kms * weight / Math.sqrt(kms) + extraConsume(kms, weight))
    oxygen += 10.0
  }
}