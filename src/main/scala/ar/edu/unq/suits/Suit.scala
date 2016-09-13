package ar.edu.unq.suits

import ar.edu.unq.damage.resistance.{NonResistance, RigidResistance, SemiRigidResistance}

class Suit extends LightSuit with NonResistance {

  def weightConsume(kms: Int, weight: Double) = kms * weight / Math.sqrt(kms)

  def walk(kms: Int, weight: Double = 0.0): Unit = {
    val consumed = walkConsume(kms) + weightConsume(kms, weight)
    oxygen = Math.max(0, oxygen - consumed)
  }
}


object RigidResistanceSuit {
  def apply(absorbing: Double): Suit = new Suit with RigidResistance {
    override val absorption: Double = absorbing
  }
}

object SemiRigidResistanceSuit {
  def apply(absorbing: Double): Suit = new Suit with SemiRigidResistance {
    override val absorption: Double = absorbing
  }
}