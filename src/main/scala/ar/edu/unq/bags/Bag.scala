package ar.edu.unq.bags

import ar.edu.unq.items.Item

import scala.collection.mutable.ListBuffer

abstract class Bag {

  val volume: Int
  val items = ListBuffer[Item]()

  def store(item: Item) = if (this fit item) items += item

  def contains(item: Item) = items contains item

  def free_space = volume - occupied_space

  def clear = items clear

  // Si no agrego asi los métodos no puedo hacer esto:
  // john = new Character
  // john.bag = new SmallBag with VacuumCompaction with Dehydrator
  // john.bag.compact
  // john.bag.dehydrate
  def compact {}
  def dehydrate {}

  protected def fit(item: Item) = free_space >= item.volume

  protected def occupied_space = items.foldLeft(0)((a,b) => a + b.volume)
}
