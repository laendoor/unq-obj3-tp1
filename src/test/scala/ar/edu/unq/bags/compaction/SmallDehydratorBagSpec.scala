package ar.edu.unq.bags.compaction

import ar.edu.unq.bags._
import ar.edu.unq.items.{Plant, Rock}

class SmallDehydratorBagSpec extends BagSpec {

  val bag = new SmallBag with Dehydrator

  "A small dehydratator bag" should "store a organic plant and apply dehydratation and increase free space by water level or plant" in {
    bag store new Plant(volume = 10000, waterVolume = 8000)
    bag.freeSpace shouldBe 30000
    bag.dehydrate
    bag.freeSpace shouldBe 38000
  }

  it should "store a inorganic rock and apply dehydratation and keep the same free space " in {
    bag store new Rock(10000)
    bag.freeSpace shouldBe 30000
    bag.dehydrate
    bag.freeSpace shouldBe 30000
  }

}
