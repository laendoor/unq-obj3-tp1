package ar.edu.unq.bags

import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec

abstract class BagSpec extends BaseSpec {

  val bag: Bag

  after {
    bag clear
  }

  protected def can_store_rock_of(volume: Int): Boolean = {
    val rock = new Rock(volume)

    bag store rock

    bag contains rock
  }

  protected def store_rock_of(volume: Int): Unit = {
    bag store (new Rock(volume))
  }

}
