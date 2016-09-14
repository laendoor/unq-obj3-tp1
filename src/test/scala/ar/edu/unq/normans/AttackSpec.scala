package ar.edu.unq.normans

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.damage._
import ar.edu.unq.suits.Suit
import ar.edu.unq.utils.BaseSpec

trait AttackSpec extends BaseSpec {

  "A red-character with 200 points of energy that is attacked from a blue-character with 1 point of power attack" should "have 189 points of energy after attack when blue-character have a laser gun" in {
    val red  = Character(energy = 200)
    val blue = new Character with Laser {
      bag    = new SmallBag
      suit   = new Suit
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 11
    blue attack red
    red.energy shouldBe 189
    blue.powerAttack shouldBe 10
  }

  it should "have 196 points of energy after attack when blue-character have a fire gun with 1 bullet" in {
    val red  = Character(energy = 200)
    val blue = new Character with FireGun {
      bag  = new SmallBag
      suit = new Suit
      bullets = 1
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 4
    blue attack red
    red.energy shouldBe 196
    blue.bullets shouldBe 0
    blue.powerAttack shouldBe 1
  }

  it should "have 196 points of energy after attack when blue-character have a rare weapon with 6 points of power attack" in {
    val red  = Character(energy = 200)
    val blue = new Character with RareWeapon {
      override val damage = 6.0
      bag  = new SmallBag
      suit = new Suit
      energy = 100
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 7
    blue attack red
    red.energy shouldBe 193
    blue.energy shouldBe 94
  }


  it should "have 186 points of energy after attack when blue-character have a rare weapon   and Duplicators with 6 points of power attack " in{

    val red  = Character(energy = 200)
    val blue = new Character with RareWeapon with Duplicators {
      override val damage = 6.0
      bag  = new SmallBag
      suit = new Suit
      energy = 100
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 14
    blue attack red
    red.energy shouldBe 186
    blue.energy shouldBe 94
  }

  it should "have 191 points of energy after attack when blue-character have a rare weapon   and Enhancers with 6 points of power attack " in{

    val red  = Character(energy = 200)
    val blue = new Character with RareWeapon with Enhancers {
      override val damage = 6.0
      override val incrementdamage = 2.0
      bag  = new SmallBag
      suit = new Suit
      energy = 100
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 9
    blue attack red
    red.energy shouldBe 191
    blue.energy shouldBe 94
  }

  it should " prueba" in {

    // poder de ataque = 4
    val red  = new Character with FireGun {
      bag  = new SmallBag
      suit = new Suit
      energy = 200
      bullets = 1
      powerAttack = 1.0
    }

    val blue = new Character with DamageAbsorption {
      bag  = new SmallBag
      suit = new Suit
      override val absorption: Double = 0.5
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 1
    red.powerAttack shouldBe 4
    red attack blue
    blue.powerAttack shouldBe 3
  }


}
