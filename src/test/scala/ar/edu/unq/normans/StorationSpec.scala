package ar.edu.unq.normans

import ar.edu.unq.bags.{Dehydration, SmallBag, VacuumCompaction}
import ar.edu.unq.items.{Ball, Plant, Rock}
import ar.edu.unq.utils.BaseSpec

trait StorationSpec extends BaseSpec {

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

  "A character in a planet with gravity of 10 m/s^2 and a small bag" should "store a rock of 10 cc3 of volume and 4 kg of mass" in {
    val miles = new Character
    miles.bag = new SmallBag
    miles.gravity = 10

    miles canStore new Rock(volume = 10, mass = 4) shouldBe true
  }
}