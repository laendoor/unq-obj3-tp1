package ar.edu.unq.bags

trait ResistanceBag extends Bag {

  val absorption: Double

  protected def absorb(damage: Double): Double
  def receiveHit(damage: Double) = {
    items.foreach { item => item.receiveHit(this absorb damage) }
  }
}

trait RigidBag extends ResistanceBag {
  override def absorb(damage: Double) = damage * (1 - absorption)
}

trait SemiRigidBag extends ResistanceBag {
  override def absorb(damage: Double) = {
    if (damage > absorption) damage - absorption else 0
  }
}

trait  RegularBag extends ResistanceBag {
  override def absorb(damage: Double) = damage
}