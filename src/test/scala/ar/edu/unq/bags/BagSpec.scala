package ar.edu.unq.bags

import ar.edu.unq.items._
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
  protected def store_ball_of(volume: Int) = store (new Ball(volume))
  protected def store_paper_of(volume: Int, cp: Int) = store (new Paper(volume, cp))
  protected def store_plant_of(volume: Int, wv: Int) = store (new Plant(volume, wv))

}

trait Compactable extends BaseSpec {

  def compact: Unit
}

trait Dehydratable extends BaseSpec {

  def dehydrate: Unit
}