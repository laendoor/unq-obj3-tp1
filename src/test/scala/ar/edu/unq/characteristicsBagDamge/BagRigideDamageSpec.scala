package ar.edu.unq.characteristicsBagDamge
import ar.edu.unq.characteristicsBagDamage.BagRigid
import ar.edu.unq.utils.BaseSpec
import ar.edu.unq.normans.Character

import ar.edu.unq.utils.BaseSpec



class BagRigidDamageSpec extends BaseSpec{


    var damage = 50


    " " should "damage 50%" in {
      var jhon = new Character with BagRigid

      jhon.shield(damage) shouldBe(25)
    }



  }
