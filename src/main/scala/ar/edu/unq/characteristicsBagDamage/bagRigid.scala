package ar.edu.unq.characteristicsBagDamage


trait BagRigid {

  def shield(damage: Double) = damage / 2

}

trait BagSemiRigid {
    def shield(damage: Double) = damage -10


  }

trait  BagRegular {

    def shield(damage: Double) = damage
  }

