package ar.edu.unq.normans

import ar.edu.unq.bags.Bag
import ar.edu.unq.items.Item
import ar.edu.unq.suits.Suit

class Character {

  var bag: Bag = _
  var suit: Suit = _
  var energy: Double = 0
  var altitude: Double = 0.0

  private var _gravity: Double = 9.8 // m/s^2, default on earth
  def gravity = _gravity
  def gravity_= (grav: Double):Unit = {
    _gravity = grav
    bag.gravity = grav
  }

  def store(item: Item): Unit = bag store item
  def canStore(item: Item): Boolean = bag canStore item
  def freeSpace: Int = bag.freeSpace
  def oxygen: Double = suit.oxygen

  def receiveHit(damage: Double): Unit = {
    energy = Math.max(0, energy - damage)
    bag receiveHit damage
  }

  def ascend(time: Int): Unit = {
    val ascendingTime = Math.min(time, bag.propulsionTime)
    bag consumeFuelFor ascendingTime
    altitude += ascendingTime / 2
//    for (t <- 1 to time) {
//      if (bag hasFuelFor 1) {
//        altitude += 0.5
//        bag consumeFuelFor 1
//      }
//    }
  }

  def walk(kms: Int): Unit = {
    suit walk (kms, bag.occupiedWeight)
  }

}