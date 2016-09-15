package ar.edu.unq.normans

import ar.edu.unq.damage._
import ar.edu.unq.utils.BaseSpec

trait AttackSpec extends BaseSpec {

  "A red-character with 200 points of energy that is attacked from a blue-character with 1 point of power attack" should "have 189 points of energy after attack when blue-character have a laser gun" in {
    val red  = Character(energy = 200)
    val blue = new Character with Laser {
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
      energy = 100
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 7
    blue attack red
    red.energy shouldBe 193
    blue.energy shouldBe 94
  }


  it should "have 186 points of energy after attack when blue-character have a rare weapon with 6 points of power attack with duplicator" in{

    val red  = Character(energy = 200)
    val blue = new Character with RareWeapon with Duplicator {
      override val damage = 6.0
      energy = 100
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 14
    blue attack red
    red.energy shouldBe 186
    blue.energy shouldBe 94
  }

  it should "have 191 points of energy after attack when blue-character have a rare weapon with 6 points of power attack with enhancer of 2 points" in{

    val red  = Character(energy = 200)
    val blue = new Character with RareWeapon with Enhancer {
      override val damage = 6.0
      override val enhancedPower = 2.0
      energy = 100
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 9
    blue attack red
    red.energy shouldBe 191
    blue.energy shouldBe 94
  }

  it should "have 200 points of energy after attack when blue-character have a canceller" in{

    val red  = Character(energy = 200)
    val blue = new Character with RareWeapon with Canceller {
      override val damage = 6.0
      energy = 100
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 0
    blue attack red
    red.energy shouldBe 200
  }

  it should "have 3-point energy after an attack red character - character blue has a DamageAbsorption with an absorption of 0.5" in {

    val red  = new Character with FireGun {
      energy = 200
      bullets = 1
      powerAttack = 1.0
    }

    val blue = new Character with DamageAbsorption {
      override val absorption: Double = 0.5
      powerAttack = 1.0
    }

    blue.powerAttack shouldBe 1
    red.powerAttack shouldBe 4
    red attack blue
    blue.powerAttack shouldBe 3
  }

  it should "have 198 energy points after an attack blue - blue has a character with a reflection ReflectionDamage 0.5" in {

    val red  = new Character with FireGun {
      energy = 200
      bullets = 1
      powerAttack = 1.0
    }

    val blue = new Character with ReflectionDamage {
      override val reflection = 0.5
    }

    red.powerAttack shouldBe 4
    red attack blue

    red.energy shouldBe 198
  }



}
