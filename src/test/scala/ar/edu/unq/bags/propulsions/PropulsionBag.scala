package ar.edu.unq.bags.propulsions

import ar.edu.unq.bags.Bag

trait PropulsionBag extends Bag {

  var fuel: Double

  override def hasFuelFor(seconds: Int): Boolean = {
    fuel != 0 && willConsume(seconds) <= fuel
  }

  def willConsume(seconds: Int): Double = {
    seconds * occupiedWeight
  }
}
