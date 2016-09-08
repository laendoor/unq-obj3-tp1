package ar.edu.unq.bags.resistance

import ar.edu.unq.bags.{SemiRigidBag, SmallBag}
import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec

trait SemiRigidSpec extends BaseSpec {

  "A small rigid bag with 20 points of absortion that receive a hit damage" should "absorb that of damage" in {
    val bag = new SmallBag with SemiRigidBag {
      override val absorption: Double = 20
    }
    val rock = new Rock(100)
    bag store rock
    bag.energy shouldBe 200
    bag receiveHit 100
    bag.energy shouldBe 120
  }

}
