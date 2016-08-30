package ar.edu.unq.bags

import ar.edu.unq.items.Rock

class SmallBagSpec extends BagSpec {

  val bag = new SmallBag

  "A small bag" should "store a rock of 0 cc3" in {
    can_store_rock_of(0) shouldBe true
  }

  it should "store a rock of 40000 cc3" in {
    can_store_rock_of(40000) shouldBe true
  }

  it should "not store a rock of 40001 cc3" in {
    can_store_rock_of(40001) shouldBe false
  }

  it should "have a 40000 cc3 of free space with no items inside" in {
    bag.free_space() shouldBe 40000
  }

  it should "have 10000 cc3 of free space after store items for 30000 cc3" in {
    bag.store(new Rock(20000))
    bag.store(new Rock(10000))

    bag.free_space() shouldBe 10000
  }

  it should "not have free space after store items for 40000 cc3" in {
    bag.store(new Rock(20000))
    bag.store(new Rock(10000))
    bag.store(new Rock(5000))
    bag.store(new Rock(5000))

    bag.free_space() shouldBe 0
  }
}
