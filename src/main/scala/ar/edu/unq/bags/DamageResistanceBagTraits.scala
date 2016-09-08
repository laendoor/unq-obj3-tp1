package ar.edu.unq.bags

trait Rigidity extends Bag {
  override def absorb(damage: Double) = damage * (1 - absorption)
}

trait SemiRigidity extends Bag {
  override def absorb(damage: Double) = {
    if (damage > absorption) damage - absorption else 0
  }
}

trait NonRigidity extends Bag {
  override def absorb(damage: Double) = damage
}