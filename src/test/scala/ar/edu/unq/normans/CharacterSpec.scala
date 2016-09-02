package ar.edu.unq.normans

import ar.edu.unq.bags.{Dehydrator, RigidBag, SmallBag, VacuumCompaction}
import ar.edu.unq.items.{Ball, Plant, Rock}
import ar.edu.unq.utils.BaseSpec

class CharacterSpec extends BaseSpec {

  val miles = new Character

  "A character in a planet with gravity of 10 m/s^2 and a small bag" should "store a rock of 10 cc3 of volume and 4 kg of mass" in {
    miles.bag = new SmallBag
    miles.gravity = 10

    miles canStore new Rock(volume = 10, mass = 4) shouldBe true
  }

  "A character with an small dehydratator bag" should "store a organic plant and apply dehydratation and increase free space by water level or plant" in {
    miles.bag = new SmallBag with Dehydrator
    miles store new Plant(volume = 10000, waterVolume = 8000)

    miles.freeSpace shouldBe 30000
    miles.dehydrate
    miles.freeSpace shouldBe 38000
  }

  "A character with an small vacuum compaction bag" should "store a compactable ball and apply compaction and free space increases by 50% of ball volume" in {
    miles.bag = new SmallBag with VacuumCompaction
    miles store new Ball(10000)

    miles.freeSpace shouldBe 30000
    miles.compact
    miles.freeSpace shouldBe 35000
  }

  "A character with 200 of energy and an small rigid bag with 60% of absortion that receive a hit damage" should "absorb 60% of damage" in {
    miles.energy = 200
    miles.bag = new SmallBag with RigidBag {
      override val absorption: Double = 0.6
    }

    miles receiveHit 100
    miles.energy shouldBe 160
  }
}
