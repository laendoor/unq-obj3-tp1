package ar.edu.unq.normans

import ar.edu.unq.bags.{Bag, Propulsion}
import ar.edu.unq.items.Rock
import ar.edu.unq.suits.{HeavySuit, Suit}
import ar.edu.unq.utils.BaseSpec

trait MovementsSpec extends BaseSpec {
  "A character with propulsion bag with 1000 units of fuel" should "ascends for 6 seconds and reach altitude of 3 meters" in {
    val miles = new Character {
      bag = new Bag with Propulsion { fuel = 1000 }
    }
    miles ascend 6
    miles.altitude shouldBe 3
  }

  "A character with propulsion bag with no fuel" should "ascends for 6 seconds and reach an altitude of 0 meters" in {
    val miles = new Character {
      bag = new Bag with Propulsion
    }
    miles ascend 6
    miles.altitude shouldBe 0
  }

  "A character on earth with heavy suit and small bag with a rock of 2kg of mass" should "walk for 2 kms and consume about 18.1 units of oxygen" in {
    val miles  = new Character {
      bag  = new Bag
      suit = new Suit with HeavySuit
    }
    miles.bag store new Rock(volume = 1000, mass = 2)

    miles walk 2

    // 2km * (2*9.8)N / sqrt(2km) + 2km * 0,2 - 10
    miles.oxygen shouldBe 3981.9 +- 0.1
  }
}
