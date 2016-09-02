package ar.edu.unq.normans

import ar.edu.unq.bags.Storeable
import ar.edu.unq.items.Item

abstract class CharacterWithBagSpec extends CharacterSpec with Storeable {

  val miles: Character

  after {
    miles.bag clear
  }

  override def free_space: Int      = miles.bag freeSpace
  override def store(item: Item)    = miles.bag store item
  override def contains(item: Item) = miles.bag contains item

}
