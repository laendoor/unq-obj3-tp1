package ar.edu.unq.bags

import ar.edu.unq.items.Item

import scala.collection.mutable.ListBuffer

abstract class Bag {

  val volume: Int
  val items = ListBuffer[Item]()

  def store(item: Item)    = if (this canStore item) items += item
  def canStore(item: Item) = freeSpace >= item.volume
  def contains(item: Item) = items contains item

  def clear     = items clear
  def energy    = items.foldLeft(0.0){ (acc, item) => acc + item.energy }
  def freeSpace = volume - occupiedSpace

  protected def occupiedSpace = items.foldLeft(0) { (acc, item) => acc + item.volume }
}
