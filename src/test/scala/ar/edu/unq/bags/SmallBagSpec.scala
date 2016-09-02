package ar.edu.unq.bags

import ar.edu.unq.items.Rock

class SmallBagSpec extends BagSpec {

  // Volume = 40L
  // Weight = 40N
  val bag = new SmallBag

  "A small bag" should "store a rock of 0 cc3" in {
    bag canStore new Rock(volume = 0) shouldBe true
  }

  it should "store a rock of 40000 cc3" in {
    bag canStore new Rock(40000) shouldBe true
  }

  it should "not store a rock of 40001 cc3" in {
    bag canStore new Rock(40001) shouldBe false
  }

  it should "have a 40000 cc3 of free space with no items inside" in {
    bag.freeSpace shouldBe 40000
  }

  it should "have 10000 cc3 of free space after store items for 30000 cc3" in {
    bag store new Rock(20000)
    bag store new Rock(10000)

    bag.freeSpace shouldBe 10000
  }

  it should "not have free space after store items for 40000 cc3" in {
    bag store new Rock(20000)
    bag store new Rock(10000)
    bag store new Rock(5000)
    bag store new Rock(5000)

    bag.freeSpace shouldBe 0
  }


  /*
   * Bonus: Masses & Weights
   */

  "A small bag in gravity of 10 m/s^2" should "store a rock of 10 cc3 of volume and 0 kg of mass" in {
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 0) shouldBe true
  }

  it should "store a rock of 10 cc3 of volume and 4 kg of mass" in {
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 4) shouldBe true
  }

  it should "store a rock of 10 cc3 of volume and 4.1 kg of mass" in {
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 4.1) shouldBe false
  }
}
