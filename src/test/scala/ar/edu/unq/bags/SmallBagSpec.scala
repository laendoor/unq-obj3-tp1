package ar.edu.unq.bags

import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec

// Volume = 40L
// Weight = 40N
trait SmallBagSpec extends BaseSpec {

  "A small bag of 40L of volume and 40N of weight resistance" should "store a rock of 0L" in {
    val bag = new SmallBag
    bag canStore new Rock(volume = 0) shouldBe true
  }

  it should "store a rock of 40L" in {
    val bag = new SmallBag
    bag canStore new Rock(volume = 40000) shouldBe true
  }

  it should "not store a rock of 41L" in {
    val bag = new SmallBag
    bag canStore new Rock(volume = 41000) shouldBe false
  }

  it should "have a 40L of free space with no items inside" in {
    val bag = new SmallBag
    bag.freeSpace shouldBe 40000
  }

  it should "have 10L of free space after store items for 30L" in {
    val bag = new SmallBag
    bag store new Rock(volume = 20000)
    bag store new Rock(volume = 10000)
    bag.freeSpace shouldBe 10000
  }

  it should "not have free space after store items for 40L" in {
    val bag = new SmallBag
    bag store new Rock(volume = 20000)
    bag store new Rock(volume = 10000)
    bag store new Rock(volume = 5000)
    bag store new Rock(volume = 5000)
    bag.freeSpace shouldBe 0
  }


  /*
   * Bonus: Masses & Weights
   */

  "A small bag in gravity of 10 m/s^2" should "store a rock of 10 cc3 of volume and 0 kg of mass" in {
    val bag = new SmallBag
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 0) shouldBe true
  }

  it should "store a rock of 10 cc3 of volume and 4 kg of mass" in {
    val bag = new SmallBag
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 4) shouldBe true
  }

  it should "not store a rock of 10 cc3 of volume and 4.1 kg of mass" in {
    val bag = new SmallBag
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 4.1) shouldBe false
  }
}
