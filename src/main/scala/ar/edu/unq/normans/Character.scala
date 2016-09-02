package ar.edu.unq.normans

import ar.edu.unq.bags.Bag
import ar.edu.unq.items.Item

class Character {

  var bag: Bag = _
  var energy: Double = 0

  private var _gravity: Double = 9.8 // m/s^2, default on earth
  def gravity = _gravity
  def gravity_= (grav: Double):Unit = {
    _gravity = grav
    bag.gravity = grav
  }

  def store(item: Item): Unit = bag store item
  def canStore(item: Item): Boolean = bag canStore item
  def freeSpace: Int = bag.freeSpace

  def compact: Unit   = bag.compact
  def dehydrate: Unit = bag.dehydrate

  def receiveHit(damage: Double): Unit = {
    energy = Math.max(0, energy - bag.absorb(damage))
    bag.receiveHit(damage)
  }

}