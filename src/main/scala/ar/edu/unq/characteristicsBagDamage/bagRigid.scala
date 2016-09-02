package ar.edu.unq.characteristicsBagDamage


trait BagRigid {

  def shield(damage: Int): Unit = {
    return damage / 2

  }

trait   BagSemiRigid {
    def shield(damage: Int): Unit = {
      return damage - 10
    }

  }

trait  BagRegular {

    def shield(damage: Int): Unit = {
      return damage
    }
  }

}