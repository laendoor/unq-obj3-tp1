package ar.edu.unq.spacesuits

class HeavySpaceSuitSpec extends SpaceSuitSpec {

  val suit = new HeavySpaceSuit
  suit.oxygen shouldBe 4000

  "A ligth space suit" should "walk 1000 kms and decreases oxygen by 190 units" in {
    suit walk 1000
    suit.oxygen shouldBe 3810
  }
}
