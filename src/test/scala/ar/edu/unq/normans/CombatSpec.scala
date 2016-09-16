package ar.edu.unq.normans

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.combat.Combat
import ar.edu.unq.damage.{FireGun, Laser}
import ar.edu.unq.suits.Suit
import ar.edu.unq.utils.BaseSpec

trait CombatSpec extends BaseSpec {

  "When blue(energy = 20, powerAttack = 10) fight round with red(energy = 10, powerAttack = 10)" should "win blue" in {
    val blue = new Character with Laser {
      bag    = new SmallBag
      suit   = new Suit
      energy = 20
    }

    val red  = new Character with Laser {
      bag    = new SmallBag
      suit   = new Suit
      energy = 10
    }

    val combat = new Combat(blue, red)

    blue.energy shouldBe 20
    blue.powerAttack shouldBe 10
    red.energy shouldBe 10
    red.powerAttack shouldBe 10

    combat.start()
    combat.winner shouldBe blue
  }

  "This test is to test a total attack" should "Where the winner is the blue-character" in {
    val red  = new Character with Laser {
      energy = 200
      bag    = new SmallBag
      suit   = new Suit
      powerAttack = 1.0
    }
    val blue = new Character with Laser {
      energy = 200
      bag    = new SmallBag
      suit   = new Suit
      powerAttack = 1.0
    }

    val combat = new Combat(blue, red)
    combat.start()
    combat.winner shouldBe blue
  }

  it should " This test is to test a total attack Where the winner is the red-character" in {
    val red  = new Character with Laser{
      energy = 200
      bag    = new SmallBag
      suit   = new Suit
      powerAttack = 1.0
    }
    val blue = new Character with FireGun {
      bag  = new SmallBag
      suit = new Suit
      bullets = 5
      powerAttack = 1.0
    }

    val combat = new Combat(red, blue)
    combat.start()
    combat.winner shouldBe red
  }

}
