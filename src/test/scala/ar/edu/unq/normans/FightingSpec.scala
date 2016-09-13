package ar.edu.unq.normans

import ar.edu.unq.suits.{RigidResistanceSuit, SemiRigidResistanceSuit, Suit}
import ar.edu.unq.utils.BaseSpec

trait FightingSpec extends BaseSpec {

  "A character with 200 of energy and a regular suit that receives damage by 100" should "have 100 of energy" in {
    val miles  = Character(energy = 200, new Suit)

    miles receiveHit 100
    miles.energy shouldBe 100
  }

  "A character with 200 of energy and a rigid suit with 50% of damage absorption that receives damage by 100" should "have 150 of energy" in {
    val miles  = Character(energy = 200, RigidResistanceSuit(absorbing = 0.5))

    miles receiveHit 100
    miles.energy shouldBe 150
  }

  "A character with 200 of energy and a semi-rigid suit with 30 points of damage absorption that receives damage by 100" should "have 130 of energy" in {
    val miles  = Character(energy = 200, SemiRigidResistanceSuit(absorbing = 30))

    miles receiveHit 100
    miles.energy shouldBe 130
  }
}
