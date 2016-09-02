package ar.edu.unq.bags

class SmallDehydratorBagSpec extends BagSpec with DehydratationSpec {

  val bag = new SmallBag with Dehydrator

  override def dehydrate: Unit = bag dehydrate

}

trait DehydratationSpec extends Storeable with Dehydratable {

  "A small dehydratator bag" should "store a organic plant and apply dehydratation and increase free space by water level or plant" in {
    this store_plant_of (10000, 8000)
    free_space shouldBe 30000
    dehydrate
    free_space shouldBe 38000
  }

  it should "store a inorganic rock and apply dehydratation and keep the same free space " in {
    this store_rock_of 10000
    free_space shouldBe 30000
    dehydrate
    free_space shouldBe 30000
  }

}
