package ar.edu.unq.bags

import ar.edu.unq.items.Item
import scala.collection.mutable.ListBuffer

abstract class Bag extends NoPropulsionBag {

  val volume: Int
  val weight: Int
  var gravity: Double = 9.8
  val absorption: Double = 0.0
  val items = ListBuffer[Item]()

  def store(item: Item)    = if (this canStore item) items += item
  def canStore(item: Item) = fitByVolume(item) && fitByWeight(item)

  def energy     = items map (_.energy) sum
  def freeSpace  = volume - occupiedSpace
  def freeWeight = weight - occupiedWeight
  def occupiedSpace  = items map (_.volume) sum
  def occupiedWeight = items map (_.mass * gravity) sum

  def absorb(damage: Double): Double = damage
  def receiveHit(damage: Double) = {
    items foreach { item => item receiveHit (this absorb damage) }
  }

  protected def fitByVolume(item: Item) = freeSpace >= item.volume
  protected def fitByWeight(item: Item) = freeWeight >= item.mass * gravity
}
