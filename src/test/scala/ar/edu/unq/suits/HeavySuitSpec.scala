package ar.edu.unq.suits

import ar.edu.unq.utils.BaseSpec

// Consumes 20% of the kms walked and generates 10 units in every walk
trait HeavySuitSpec extends BaseSpec {

  "A heavy space suit" should "have 4000 units of oxygen" in {
    val suit = new HeavySuit
    suit.oxygen shouldBe 4000
  }

  it should "decreases in 190 units of oxygen when walking for 1000 kms" in {
    val suit = new HeavySuit
    suit walk 1000
    suit.oxygen shouldBe 3810
  }
}
