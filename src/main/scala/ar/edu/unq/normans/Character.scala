package ar.edu.unq.normans

import ar.edu.unq.bags.Bag
import ar.edu.unq.damage.PowerAttack
import ar.edu.unq.items.Item
import ar.edu.unq.suits.Suit

class Character extends PowerAttack {

  var bag: Bag = new Bag
  var suit: Suit = new Suit
  var energy: Double = 0
  var fatigue: Double = 0
  var altitude: Double = 0.0

  private var _gravity: Double = 9.8 // m/s^2, default on earth
  def gravity = _gravity
  def gravity_= (grav: Double):Unit = {
    _gravity = grav
    bag.gravity = grav
  }

  def store(item: Item): Unit = bag store item
  def canStore(item: Item): Boolean = bag canStore item
  def freeSpace: Double = bag.freeSpace
  def oxygen: Double = suit.oxygen

  def receiveHit(damage: Double, other: Character): Unit = {
    val effectiveDamage = suit absorb damage
    energy = Math.max(0, energy - effectiveDamage)
    bag.receiveHit(effectiveDamage)
  }

  override def attack(other: Character): Unit = {
    other.receiveHit(powerAttack,this)
  }

  // FIXME? lo podria hacer directamente la propulsion y llevarse el attr altitude
  def ascend(time: Int): Unit = {
    val ascendingTime = Math.min(time, bag.propulsionTime)
    bag consumeFuelFor ascendingTime
    altitude += ascendingTime / 2
  }

  /** Walking affects the Suit and generates fatigue */
  def walk(kms: Int): Unit = {
    suit walk (kms, bag.weight)
    fatigue += 0.5 * (kms + bag.weight)
  }

}

object Character {

  def apply(energy: Int): Character = {
    apply(energy, new Suit)
  }

  def apply(energy: Int, suit: Suit): Character = {
    val c = new Character
    c.bag    = new Bag
    c.suit   = suit
    c.energy = energy
    c
  }
}
