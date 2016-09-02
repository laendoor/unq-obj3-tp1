package ar.edu.unq.bags.resistance

import ar.edu.unq.bags.{BagSpec, RigidBag, SemiRigidBag, SmallBag}
import ar.edu.unq.items.Rock

class SmallSemiRigidBagSpec extends BagSpec {

  val bag = new SmallBag with SemiRigidBag {
    override val absorption: Double = 20
  }

  "A small rigid bag with 20 points of absortion that receive a hit damage" should "absorb that of damage" in {
    val rock = new Rock(100)
    bag store rock
    bag.energy shouldBe 200
    bag receiveHit 100
    bag.energy shouldBe 120
  }

}
