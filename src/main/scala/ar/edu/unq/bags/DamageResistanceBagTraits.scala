package ar.edu.unq.bags

trait Rigidity extends Bag {
  override def absorb(damage: Double) = damage * (1 - absorption)
}

trait SemiRigidity extends Bag {
  override def absorb(damage: Double) = Math.max(0, damage - absorption)
}

trait NonRigidity {
  val absorption: Double = 0.0
  def absorb(damage: Double) = damage
}