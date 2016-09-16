package ar.edu.unq.normans

import ar.edu.unq.combat.Combat
import ar.edu.unq.damage.{FireGun, Laser}
import ar.edu.unq.utils.BaseSpec

trait CombatSpec extends BaseSpec {

  "When blue(energy = 20, powerAttack = 10) fight a round with red(energy = 10, powerAttack = 10)" should "win blue" in {
    val red  = new Character with Laser { energy = 10 }
    val blue = new Character with Laser { energy = 20 }
    val combat = new Combat(blue, red)

    combat.roundFight()
    combat.winner shouldBe blue
  }

  "This test is to test a total attack" should "Where the winner is the blue-character" in {
    val red  = new Character with Laser { energy = 200; powerAttack = 1.0 }
    val blue = new Character with Laser { energy = 200; powerAttack = 1.0 }
    val combat = new Combat(blue, red)

    combat.fight()
    combat.winner shouldBe blue
  }

  it should " This test is to test a total attack Where the winner is the red-character" in {
    val red  = new Character with Laser  { energy = 200; powerAttack = 1.0 }
    val blue = new Character with FireGun { bullets = 5; powerAttack = 1.0 }
    val combat = new Combat(red, blue)

    combat.fight()
    combat.winner shouldBe red
  }

  "In combat where Red loose all energy" should "win blue" in {
    val red  = new Character with Laser { energy =  50; powerAttack = 2.0 }
    val blue = new Character with Laser { energy = 200; powerAttack = 1.0 }
    val combat = new Combat(blue, red)

    combat.fight()
    red.energy shouldBe 0
    red.powerAttack should be > blue.powerAttack
    combat.winner shouldBe blue
  }

}
