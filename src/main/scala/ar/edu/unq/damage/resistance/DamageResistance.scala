package ar.edu.unq.damage.resistance

trait NonResistance {
  val absorption: Double = 0.0
  def absorb(damage: Double) = damage
}

trait RigidResistance extends NonResistance {
  override def absorb(damage: Double) = damage * (1 - absorption)
}

trait SemiRigidResistance extends NonResistance {
  override def absorb(damage: Double) = Math.max(0, damage - absorption)
}
