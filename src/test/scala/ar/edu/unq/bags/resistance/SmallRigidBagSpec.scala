package ar.edu.unq.bags.resistance

import ar.edu.unq.bags.{BagSpec, RigidBag, SmallBag}
import ar.edu.unq.items.Rock

class SmallRigidBagSpec extends BagSpec {

  val bag = new SmallBag with RigidBag {
    override val absorption: Double = 0.6
  }

  "A small rigid bag with 60% of absortion that receive a hit damage" should "absorb 60% of damage" in {
    val rock = new Rock(100)
    bag store rock
    bag.energy shouldBe 200
    bag receiveHit 100
    bag.energy shouldBe 160
  }

}
