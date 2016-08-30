package ar.edu.unq.bags

import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec
import org.scalatest.BeforeAndAfter

abstract class BagSpec extends BaseSpec {

  val bag: Bag

  after {
    bag.clear
  }

  protected def can_store_rock_of(volume: Int) = {
    val rock = new Rock(volume)

    bag.store(rock)

    bag.contains(rock)
  }

}
