package ar.edu.unq.characteristicsBagDamge

import ar.edu.unq.characteristicsBagDamage.{BagRegular, BagRigid}
import ar.edu.unq.normans.Character
import ar.edu.unq.utils.BaseSpec


class BagRegularSpec extends BaseSpec{


  var damage = 50


  " " should "damage 100%" in {
    var jhon = new Character with BagRegular

    jhon.shield(damage) shouldBe(50)
  }

}
