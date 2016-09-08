package ar.edu.unq.bags

trait PropulsionBag extends Bag {

  var fuel: Double

  override def hasFuelFor(seconds: Int): Boolean = {
    fuel != 0 && willConsume(seconds) <= fuel
  }

  def willConsume(seconds: Int): Double = {
    seconds * occupiedWeight
  }
}
