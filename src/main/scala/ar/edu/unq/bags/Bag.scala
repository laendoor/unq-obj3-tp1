package ar.edu.unq.bags

import ar.edu.unq.damage.NonResistance
import ar.edu.unq.items.Item

import scala.collection.mutable.ListBuffer

class Bag extends SmallSize with NonResistance with NoPropulsion {

  val items = ListBuffer[Item]()

  def store(item: Item)    = if (this canStore item) items += item
  def canStore(item: Item) = fitByVolume(item) && fitByWeight(item)

  def weight     = items map (_.mass * gravity) sum
  def energy     = items map (_.energy) sum
  def freeSpace  = volume - occupiedSpace
  def freeWeight = weightResistance - weight
  def occupiedSpace  = items map (_.volume) sum

  def receiveHit(damage: Double) = {
    items foreach { item => item receiveHit (this absorb damage) }
  }

  protected def fitByVolume(item: Item) = freeSpace >= item.volume
  protected def fitByWeight(item: Item) = freeWeight >= item.mass * gravity
}


/**
  * Bag Size:
  *  - weightResistance -> Newton = m*g
  *  - volume -> cc3
  */

trait SmallSize {
  val weightResistance: Double = 40.0
  val volume: Double = 40000.0
}

trait MediumSize extends Bag {
  override val weightResistance = 60.0
  override val volume = 60000.0
}

trait LargeSize extends Bag {
  override val weightResistance = 90.0
  override val volume = 90000.0
}
