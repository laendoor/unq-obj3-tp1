package ar.edu.unq.bags.resistance

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec

trait NonRigiditySpec extends BaseSpec {

  "A small regular rigid bag that receive a hit damage" should "not absorb damage" in {
    val bag  = new SmallBag
    val rock = new Rock(100)
    bag store rock
    bag.energy shouldBe 200
    bag receiveHit 100
    bag.energy shouldBe 100
  }

}
