package ar.edu.unq.normans

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.utils.BaseSpec

trait FightingSpec extends BaseSpec {
  "A character with 200 of energy that receive a hit damage of 100" should "have 100 of energy" in {
    val miles = new Character
    miles.bag = new SmallBag
    miles.energy = 200

    miles receiveHit 100
    miles.energy shouldBe 100
  }
}
