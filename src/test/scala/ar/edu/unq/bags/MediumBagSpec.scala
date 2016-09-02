package ar.edu.unq.bags

class MediumBagSpec extends BagSpec with MediumStoring {

  val bag = new MediumBag

}
trait MediumStoring extends Storeable {
/*

  "A medium bag" should "store a rock of 0 cc3" in {
    can_store_rock_of(0) shouldBe true
  }

  it should "store a rock of 60000 cc3" in {
    can_store_rock_of(60000) shouldBe true
  }

  it should "not store a rock of 60001 cc3" in {
    can_store_rock_of(60001) shouldBe false
  }

  it should "have a 60000 cc3 of free space with no items inside" in {
    free_space shouldBe 60000
  }

  it should "have 30000 cc3 of free space after store items for 30000 cc3" in {
    this store_rock_of 20000
    this store_rock_of 10000

    free_space shouldBe 30000
  }

  it should "not have free space after store items for 60000 cc3" in {
    this store_rock_of 20000
    this store_rock_of 10000
    this store_rock_of 10000
    this store_rock_of 5000
    this store_rock_of 5000
    this store_rock_of 2500
    this store_rock_of 2500
    this store_rock_of 2500
    this store_rock_of 2500

    free_space shouldBe 0
  }
*/
}
