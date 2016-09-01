package ar.edu.unq.bags

import ar.edu.unq.items.{Item, Rock}
import ar.edu.unq.utils.BaseSpec

abstract class BagSpec extends Storeable {

  val bag: Bag

  after {
    bag clear
  }

  override def free_space: Int      = bag.free_space
  override def store(item: Item)    = bag store item
  override def contains(item: Item) = bag contains item

}


trait Storeable extends BaseSpec {

  def free_space: Int
  def store(item: Item): Unit
  def contains(item: Item): Boolean

  protected def can_store_rock_of(volume: Int): Boolean = {
    val rock = new Rock(volume)

    this store rock

    this contains rock
  }

  protected def store_rock_of(volume: Int) = store (new Rock(volume))

}