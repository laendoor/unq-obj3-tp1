package ar.edu.unq.bags

import ar.edu.unq.items.Item

import scala.collection.mutable.ListBuffer

abstract class Bag {

  val volume: Int
  val weight: Int
  val absorption: Double = 0.0
  var gravity: Double = 9.8 // m/s^2, default on earth
  val items = ListBuffer[Item]()

  def store(item: Item)    = if (this canStore item) items += item
  def canStore(item: Item) = freeSpace >= item.volume && freeWeight >= item.mass * gravity
  def contains(item: Item) = items contains item

  def clear()    = items.clear
  def energy     = items.foldLeft(0.0){ (acc, item) => acc + item.energy }
  def freeSpace  = volume - occupiedSpace
  def freeWeight = weight - occupiedWeight

  def absorb(damage: Double): Double = damage
  def receiveHit(damage: Double) = {
    items.foreach { item => item.receiveHit(this absorb damage) }
  }

  def hasFuelFor(seconds: Int): Boolean = false
  def consume(time: Int) {}

  def occupiedWeight = items.foldLeft(0.0) { (acc, item) => acc + item.mass * gravity }
  protected def occupiedSpace  = items.foldLeft(0) { (acc, item) => acc + item.volume }
}
