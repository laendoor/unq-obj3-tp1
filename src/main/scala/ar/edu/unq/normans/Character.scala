package ar.edu.unq.normans

import ar.edu.unq.bags.Bag
import ar.edu.unq.items.Item
import ar.edu.unq.suits.Suit
import ar.edu.unq.damage.PowerAttack

class Character extends PowerAttack {

  var bag: Bag = new Bag
  var suit: Suit = new Suit

  var xp     : Int = 0
  var energy : Double = 0
  var fatigue: Double = 0

  /** Oxygen & Gravity depends on Suit */
  def oxygen: Double = suit.oxygen
  def gravity = bag.gravity
  def gravity_= (gravity: Double): Unit = bag.gravity = gravity

  /** Storing depends on Bag */
  def store(item: Item): Unit = bag store item
  def canStore(item: Item): Boolean = bag canStore item
  def freeSpace: Double = bag.freeSpace

  /** Space moves depends on Bag */
  def altitude = bag.altitude
  def ascend(time: Int): Unit = {
    bag ascend time
  }

  /** Under attack */
  def receiveHit(damage: Double, other: Character): Unit = {
    val effectiveDamage = suit absorb damage
    bag receiveHit effectiveDamage
    energy = Math.max(0, energy - effectiveDamage)
  }

  /** Dale duro otto */
  override def attack(other: Character): Unit = {
    other.receiveHit(powerAttack, this)
  }

  /** Walking affects Suit and generates fatigue */
  def walk(kms: Int): Unit = {
    suit walk (kms, bag.weight)
    fatigue += 0.5 * (kms + bag.weight)
  }

  /** Used in combats */
  def isAlive = energy > 0
  def hasPowerAttack = powerAttack > 0
}

/**
  * Companion Object is used to write short & descriptive test
  */
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
