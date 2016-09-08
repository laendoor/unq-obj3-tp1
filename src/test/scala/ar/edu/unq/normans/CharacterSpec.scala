package ar.edu.unq.normans

import ar.edu.unq.bags._
import ar.edu.unq.items.{Ball, Plant, Rock}
import ar.edu.unq.spacesuits.HeavySpaceSuit
import ar.edu.unq.utils.BaseSpec

class CharacterSpec extends BaseSpec
 with CharacterBagsSpec {

  "A character with 200 of energy that receive a hit damage of 100" should "have 100 of energy" in {
    val miles = new Character
    miles.bag = new SmallBag
    miles.energy = 200

    miles receiveHit 100
    miles.energy shouldBe 100
  }

}

trait CharacterBagsSpec extends BaseSpec {

  "A character with an small dehydratator bag" should "store a organic plant and keep 38L of free space" in {
    val miles = new Character
    miles.bag = new SmallBag with Dehydration
    miles store new Plant(volume = 10000, waterVolume = 8000)
    miles.freeSpace shouldBe 38000
  }

  "A character with an small vacuum compaction bag" should "store a compactable ball and keep 35L of free space" in {
    val miles = new Character
    miles.bag = new SmallBag with VacuumCompaction
    miles store new Ball(10000)
    miles.freeSpace shouldBe 35000
  }

  "A character with propulsion bag with 1000 of fuel ascends for 6 seconds" should "has an altitude of 3 meters" in {
    val miles = new Character
    miles.bag = new SmallBag with PropulsionBag {
      override var fuel: Double = 1000
    }
    miles.ascend(6)

    miles.altitude shouldBe 3
  }

  "A character with propulsion bag with 0 of fuel ascends for 6 seconds" should "has an altitude of 0 meters" in {
    val miles = new Character
    miles.bag = new SmallBag with PropulsionBag {
      override var fuel: Double = 0
    }
    miles.ascend(6)

    miles.altitude shouldBe 0
  }

  "A character with heavy suit and small bag who walk for 2 kms" should "consume xx oxygen" in {
    val miles = new Character
    miles.bag = new SmallBag
    miles.suit = new HeavySpaceSuit
    miles.bag store new Rock(volume = 1000, mass = 2)

    miles walk 2

    miles.oxygen shouldBe 3954.162828354975
  }

  "A character in a planet with gravity of 10 m/s^2 and a small bag" should "store a rock of 10 cc3 of volume and 4 kg of mass" in {
    val miles = new Character
    miles.bag = new SmallBag
    miles.gravity = 10

    miles canStore new Rock(volume = 10, mass = 4) shouldBe true
  }
}