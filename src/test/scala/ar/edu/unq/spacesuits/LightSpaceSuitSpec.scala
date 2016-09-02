package ar.edu.unq.spacesuits

class LightSpaceSuitSpec extends SpaceSuitSpec {

  val suit = new LightSpaceSuit
  suit.oxygen shouldBe 1500

  "A ligth space suit" should "walk 60 kms and decreases oxygen by 9 units" in {
    suit walk 60
    suit.oxygen shouldBe 1491
  }

  "A ligth space suit" should "walk 100 kms and decreases oxygen by 10 units" in {
    suit walk 100
    suit.oxygen shouldBe 1490
  }
}
