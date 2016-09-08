package ar.edu.unq.bags

import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec

// Volume = 60L
// Weight = 60N
trait MediumBagSpec extends BaseSpec {

  "A medium bag" should "store a rock of 0L" in {
    val bag = new MediumBag
    bag canStore new Rock(volume = 0) shouldBe true
  }

  it should "store a rock of 60L" in {
    val bag = new MediumBag
    bag canStore new Rock(volume = 60000) shouldBe true
  }

  it should "not store a rock of 60001 cc3" in {
    val bag = new MediumBag
    bag canStore new Rock(volume = 60001) shouldBe false
  }

  it should "have a 60L of free space with no items inside" in {
    val bag = new MediumBag
    bag.freeSpace shouldBe 60000
  }

  it should "have 30L of free space after store items for 30L" in {
    val bag = new MediumBag
    bag store new Rock(volume = 20000)
    bag store new Rock(volume = 10000)
    bag.freeSpace shouldBe 30000
  }

  it should "not have free space after store items for 60L" in {
    val bag = new MediumBag
    bag store new Rock(volume = 20000)
    bag store new Rock(volume = 10000)
    bag store new Rock(volume = 10000)
    bag store new Rock(volume = 5000)
    bag store new Rock(volume = 5000)
    bag store new Rock(volume = 2500)
    bag store new Rock(volume = 2500)
    bag store new Rock(volume = 2500)
    bag store new Rock(volume = 2500)
    bag.freeSpace shouldBe 0
  }

  /*
   * Bonus: Masses & Weights
   */

  "A medium bag in gravity of 10 m/s^2" should "store a rock of 10 cc3 of volume and 0 kg of mass" in {
    val bag = new MediumBag
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 0) shouldBe true
  }

  it should "store a rock of 10 cc3 of volume and 6 kg of mass" in {
    val bag = new MediumBag
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 6) shouldBe true
  }

  it should "not store a rock of 10 cc3 of volume and 6.1 kg of mass" in {
    val bag = new MediumBag
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 6.1) shouldBe false
  }

}
