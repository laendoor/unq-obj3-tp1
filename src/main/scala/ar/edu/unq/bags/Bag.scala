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


/*
 * This SmallBag has a capacity of 40 liters (40000 cc3)
 */
class SmallBag extends Bag {

  val volume = 40000
}

/*
 * This MediumBag has a capacity of 60 liters (60000 cc3)
 */
class MediumBag extends Bag {

  val volume = 60000
}

/*
 * This LargeBag has a capacity of 90 liters (90000 cc3)
 */
class LargeBag extends Bag {

  val volume = 90000
}

trait VacuumCompaction extends Bag {

  override def compact: Unit = items.foreach { item => item.compact }

}

trait Dehydrator extends Bag {

  override def dehydrate: Unit = items.foreach { item => item.dehydrate }

}