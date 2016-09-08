package ar.edu.unq.bags.compaction

import ar.edu.unq.bags.{Dehydration, SmallBag}
import ar.edu.unq.items.{Plant, Rock}
import ar.edu.unq.utils.BaseSpec

trait DehydrationSpec extends BaseSpec {

  "A small bag (40L) with dehydration" should "store an organic plant with 10L of volume and 8L of water volume and keep 38L of free space" in {
    val bag = new SmallBag with Dehydration
    bag store new Plant(volume = 10000, waterVolume = 8000)
    bag.freeSpace shouldBe 38000
  }

  it should "store an inorganic rock with 10L of volume and keep 30L of free space" in {
    val bag = new SmallBag with Dehydration
    bag store new Rock(10000)
    bag.freeSpace shouldBe 30000
  }

}
