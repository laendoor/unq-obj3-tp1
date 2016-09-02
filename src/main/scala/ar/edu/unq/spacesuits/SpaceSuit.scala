package ar.edu.unq.spacesuits

abstract class SpaceSuit {
  var oxygen: Double = 0.0
  def walk(kms: Int): Unit
  def restoreOxygen(): Unit
  protected def consumed(amount: Double): Unit = {
    oxygen = Math.max(0, oxygen - amount)
  }
}

class LightSpaceSuit extends SpaceSuit {

  restoreOxygen()

  override def restoreOxygen(): Unit = oxygen = 1500.0
  override def walk(kms: Int): Unit = {
    consumed(Math.min(10, kms * 0.15))
  }
}

class HeavySpaceSuit extends SpaceSuit {

  restoreOxygen()

  override def restoreOxygen(): Unit = oxygen = 4000.0
  override def walk(kms: Int): Unit = {
    consumed(kms * 0.20)
    oxygen += 10.0
  }
}