package ar.edu.unq.normans

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.damage.{RechargeableShield, Shield}
import ar.edu.unq.suits.{RigidResistanceSuit, SemiRigidResistanceSuit, Suit}
import ar.edu.unq.utils.BaseSpec

trait DamageResistanceSpec extends BaseSpec {

  "A character with 200 of energy and a regular suit that receives damage by 100" should "have 100 of energy" in {
    val miles  = Character(energy = 200, new Suit)

    miles.receiveHit(100,miles)
    miles.energy shouldBe 100
  }

  "A character with 200 of energy and a rigid suit with 50% of damage absorption that receives damage by 100" should "have 150 of energy" in {
    val miles  = Character(energy = 200, RigidResistanceSuit(absorbing = 0.5))

    miles.receiveHit(100, miles)
    miles.energy shouldBe 150
  }

  "A character with 200 of energy and a semi-rigid suit with 30 points of damage absorption that receives damage by 100" should "have 130 of energy" in {
    val miles  = Character(energy = 200, SemiRigidResistanceSuit(absorbing = 30))

    miles.receiveHit(100, miles)
    miles.energy shouldBe 130
  }

  "A character with 200 of energy and a shield with 80 points of damage absorption that receives damage by 60" should "have 200 of energy and 20 points of damage absorption in shield" in {
    val miles = new Character with Shield {
      bag    = new SmallBag
      suit   = new Suit
      energy = 200
      absorption = 80.0
    }

    miles.receiveHit(60, miles)
    miles.energy shouldBe 200
    miles.absorption shouldBe 20
  }

  "A character with 200 of energy and a rechargeable shield with 80 points of damage absorption that receives damage by 60 and then walk 2 kms" should "have 200 of energy and 40 points of damage absorption in shield" in {
    val miles = new Character with RechargeableShield {
      bag    = new SmallBag
      suit   = new Suit
      energy = 200
      absorption = 80.0
    }

    miles.receiveHit(60, miles)
    miles.energy shouldBe 200
    miles.absorption shouldBe 20

    miles walk 2
    miles.absorption shouldBe 40
  }


}
