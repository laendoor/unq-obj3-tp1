package ar.edu.unq.bags

import ar.edu.unq.items.Rock
import ar.edu.unq.utils.BaseSpec

// Volume = 90L
// Weight = 90N
trait LargeBagSpec extends BaseSpec {

  "A large bag" should "store a rock of 0L" in {
    val bag = new Bag with LargeSize
    bag canStore new Rock(0) shouldBe true
  }

  it should "store a rock of 90L" in {
    val bag = new Bag with LargeSize
    bag canStore new Rock(volume = 90000) shouldBe true
  }

  it should "not store a rock of 90001 cc3" in {
    val bag = new Bag with LargeSize
    bag canStore new Rock(volume = 90001) shouldBe false
  }

  it should "have a 90L of free space with no items inside" in {
    val bag = new Bag with LargeSize
    bag.freeSpace shouldBe 90000
  }

  it should "have 60L of free space after store items for 30L" in {
    val bag = new Bag with LargeSize
    bag store new Rock(volume = 20000)
    bag store new Rock(volume = 10000)

    bag.freeSpace shouldBe 60000
  }

  it should "not have free space after store items for 90L" in {
    val bag = new Bag with LargeSize
    bag store new Rock(volume = 20000)
    bag store new Rock(volume = 20000)
    bag store new Rock(volume = 10000)
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

  "A large bag in gravity of 10 m/s^2" should "store a rock of 10 cc3 of volume and 0 kg of mass" in {
    val bag = new Bag with LargeSize
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 0) shouldBe true
  }

  it should "store a rock of 10 cc3 of volume and 9 kg of mass" in {
    val bag = new Bag with LargeSize
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 9) shouldBe true
  }

  it should "store a rock of 10 cc3 of volume and 9.1 kg of mass" in {
    val bag = new Bag with LargeSize
    bag.gravity = 10
    bag canStore new Rock(volume = 10, mass = 9.1) shouldBe false
  }

}
