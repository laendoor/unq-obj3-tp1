package ar.edu.unq.bags

import ar.edu.unq.items.Rock

class LargeBagSpec extends BagSpec {

  val bag = new LargeBag

  "A large bag" should "store a rock of 0 cc3" in {
    bag canStore (new Rock(0)) shouldBe true
  }

  it should "store a rock of 90000 cc3" in {
    bag canStore (new Rock(90000)) shouldBe true
  }

  it should "not store a rock of 90001 cc3" in {
    bag canStore (new Rock(90001)) shouldBe false
  }

  it should "have a 90000 cc3 of free space with no items inside" in {
    bag.freeSpace shouldBe 90000
  }

  it should "have 60000 cc3 of free space after store items for 30000 cc3" in {
    bag store (new Rock(20000))
    bag store (new Rock(10000))

    bag.freeSpace shouldBe 60000
  }

  it should "not have free space after store items for 90000 cc3" in {
    bag store (new Rock(20000))
    bag store (new Rock(20000))
    bag store (new Rock(10000))
    bag store (new Rock(10000))
    bag store (new Rock(10000))
    bag store (new Rock(5000))
    bag store (new Rock(5000))
    bag store (new Rock(2500))
    bag store (new Rock(2500))
    bag store (new Rock(2500))
    bag store (new Rock(2500))

    bag.freeSpace shouldBe 0
  }

}
