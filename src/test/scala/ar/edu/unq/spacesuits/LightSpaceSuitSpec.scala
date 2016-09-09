package ar.edu.unq.spacesuits

import ar.edu.unq.utils.BaseSpec

// Consumes 15% of the kms walked with a max of 10 units
trait LightSpaceSuitSpec extends BaseSpec {

  "A ligth space suit" should "have 1500 units of oxygen" in {
    val suit = new LightSpaceSuit
    suit.oxygen shouldBe 1500
  }

  it should "decreases in 9 units of oxygen when walking for 60 kms" in {
    val suit = new LightSpaceSuit
    suit walk 60
    suit.oxygen shouldBe 1491
  }

  it should "decreases in 10 units of oxygen when walking for 100 kms" in {
    val suit = new LightSpaceSuit
    suit walk 100
    suit.oxygen shouldBe 1490
  }
}
