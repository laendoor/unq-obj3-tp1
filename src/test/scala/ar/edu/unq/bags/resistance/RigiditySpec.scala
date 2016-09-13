package ar.edu.unq.bags.resistance

import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec
import ar.edu.unq.bags.{Rigidity, SmallBag}

trait RigiditySpec extends BaseSpec {

  "A small rigid bag with 60% of absortion that receive a hit damage" should "absorb 60% of damage" in {
    val bag = new SmallBag with Rigidity {
      override val absorption: Double = 0.6
    }
    val rock = new Rock(100)
    bag store rock
    bag.energy shouldBe 200
    bag receiveHit 100
    bag.energy shouldBe 160
  }

}