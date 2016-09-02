package ar.edu.unq.bags.resistance

import ar.edu.unq.bags.{BagSpec, RegularBag, SmallBag}
import ar.edu.unq.items.Rock

class SmallRegularBagSpec extends BagSpec {

  val bag = new SmallBag with RegularBag {
    override val absorption: Double = 0.0
  }

  "A small regular rigid bag that receive a hit damage" should "not absorb damage" in {
    val rock = new Rock(100)
    bag store rock
    bag.energy shouldBe 200
    bag receiveHit 100
    bag.energy shouldBe 100
  }

}
