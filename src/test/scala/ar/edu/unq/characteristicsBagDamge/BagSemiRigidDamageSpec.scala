package ar.edu.unq.characteristicsBagDamge

import ar.edu.unq.normans.Character
import ar.edu.unq.utils.BaseSpec
import ar.edu.unq.characteristicsBagDamage.{BagRigid, BagSemiRigid}

class BagSemiRigidDamageSpec extends BaseSpec{

  var damage = 50
  " " should "damage - 10" in {
    var jhon = new Character with BagSemiRigid

    jhon.shield(damage) shouldBe(40)
  }


}
