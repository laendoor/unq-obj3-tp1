package ar.edu.unq.bags

trait RigidBag extends Bag {
  override def absorb(damage: Double) = damage * (1 - absorption)
}

trait SemiRigidBag extends Bag {
  override def absorb(damage: Double) = {
    if (damage > absorption) damage - absorption else 0
  }
}

trait  RegularBag extends Bag {
  override def absorb(damage: Double) = damage
}