package ar.edu.unq.bags.compaction

import ar.edu.unq.bags._
import ar.edu.unq.items.{Ball, Paper, Rock}

class SmallVacuumCompactionBagSpec extends BagSpec {

  val bag = new SmallBag with VacuumCompaction

  "A small bag with vacuum compaction" should "store a non-compactable rock and apply compaction and keep same free space" in {
    bag store (new Rock(10000))
    bag.freeSpace shouldBe 30000
    bag.compact
    bag.freeSpace shouldBe 30000
  }

  it should "store a compactable ball and apply compaction and free space increases by 50% of ball volume" in {
    bag store (new Ball(10000))
    bag.freeSpace shouldBe 30000
    bag.compact
    bag.freeSpace shouldBe 35000
  }

  it should "store a semi-compactable paper and apply compaction and free space increases by compaction-points of ball volume" in {
    bag store (new Paper(10000, 2000))
    bag.freeSpace shouldBe 30000
    bag.compact
    bag.freeSpace shouldBe 32000
  }

}
