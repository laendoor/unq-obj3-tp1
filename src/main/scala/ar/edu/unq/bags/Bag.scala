package ar.edu.unq.bags

import ar.edu.unq.items.Item

import scala.collection.mutable.ListBuffer

abstract class Bag {

  val volume: Int
  val items = ListBuffer[Item]()

  def store(item: Item) = if (this fit item) items += item

  def contains(item: Item) = items contains item

  def freeSpace = volume - occupiedSpace

  def clear = items clear

  def energy = items.foldLeft(0.0){ (acc, item) => acc + item.energy }

  // Si no agrego asi los métodos no puedo hacer esto:
  // john = new Character
  // john.bag = new SmallBag with VacuumCompaction with Dehydrator
  // john.bag.compact
  // john.bag.dehydrate
  def compact {}
  def dehydrate {}

  protected def fit(item: Item) = freeSpace >= item.volume

  protected def occupiedSpace = items.foldLeft(0) { (acc, item) => acc + item.volume }
}
