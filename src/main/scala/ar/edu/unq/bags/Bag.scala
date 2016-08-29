package ar.edu.unq.bags

import ar.edu.unq.items.Item

import scala.collection.mutable.ListBuffer

abstract class Bag {

  val items = ListBuffer[Item]()
  val volume: Int = 50000

  def store(item : Item): Unit = {
    if (fit(item)) {
      items += item
    }
  }

  def has(item : Item) = {
    items.contains(item)
  }

  protected def fit(item: Item): Boolean = {
    true
  }
}
