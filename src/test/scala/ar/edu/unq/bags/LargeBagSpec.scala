package ar.edu.unq.bags

class LargeBagSpec extends BagSpec {

  val bag = new LargeBag

  "A large bag" should "store a rock of 0 cc3" in {
    can_store_rock_of(0) shouldBe true
  }

  it should "store a rock of 90000 cc3" in {
    can_store_rock_of(90000) shouldBe true
  }

  it should "not store a rock of 90001 cc3" in {
    can_store_rock_of(90001) shouldBe false
  }

  it should "have a 90000 cc3 of free space with no items inside" in {
    bag.free_space shouldBe 90000
  }

  it should "have 60000 cc3 of free space after store items for 30000 cc3" in {
    this store_rock_of 20000
    this store_rock_of 10000

    bag.free_space shouldBe 60000
  }

  it should "not have free space after store items for 90000 cc3" in {
    this store_rock_of 20000
    this store_rock_of 20000
    this store_rock_of 10000
    this store_rock_of 10000
    this store_rock_of 10000
    this store_rock_of 5000
    this store_rock_of 5000
    this store_rock_of 2500
    this store_rock_of 2500
    this store_rock_of 2500
    this store_rock_of 2500

    bag.free_space shouldBe 0
  }
}
