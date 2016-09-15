package ar.edu.unq.bags.compaction

import ar.edu.unq.bags.{Bag, VacuumCompaction}
import ar.edu.unq.items.{Ball, Paper, Rock}
import ar.edu.unq.utils.BaseSpec

trait VacuumCompactionSpec extends BaseSpec {

  "A small bag (40L) with vacuum compaction" should "store a non-compactable rock with 10L of volume and have 30L of free space" in {
    val bag = new Bag with VacuumCompaction
    bag store new Rock(volume = 10000)
    bag.freeSpace shouldBe 30000
  }

  it should "store a compactable ball with 10L of volume and have 35L of free space" in {
    val bag = new Bag with VacuumCompaction
    bag store new Ball(volume = 10000)
    bag.freeSpace shouldBe 35000
  }

  it should "store a semi-compactable paper with 10L of volume and 2L of compact points and have 32L of free space" in {
    val bag = new Bag with VacuumCompaction
    val paper = new Paper(volume = 10000)
    paper cp = 2000
    bag store paper
    bag.freeSpace shouldBe 32000
  }

}
