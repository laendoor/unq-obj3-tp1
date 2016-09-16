package ar.edu.unq.combat

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.damage.{FireGun, Laser}
import ar.edu.unq.normans.Character
import ar.edu.unq.suits.Suit
import ar.edu.unq.utils.BaseSpec

trait CombatTotalSpec extends BaseSpec {

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
    combat.ataqueTotal
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
    combat.ataqueTotal
    combat.winner shouldBe red
  }

}
