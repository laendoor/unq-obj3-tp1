package ar.edu.unq.normans

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec

trait CharacterWithSmallBagSpec extends BaseSpec {

  val miles = new Character with SmallBag

  "A character with an small bag" should "store a rock of 0 cc3" in {
    val rock = new Rock(0)

    miles.store(rock)

    miles.has(rock) shouldBe true
  }
}
