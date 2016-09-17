package ar.edu.unq.damage

import ar.edu.unq.normans.Character

trait Shield extends Character {
  var absorption: Double = 0.0

  override def receiveHit(damage: Double,other: Character): Unit = {
    val effectiveDamage = this absorb damage
    absorption = Math.max(0, absorption - damage)
    super.receiveHit(effectiveDamage,other)
  }

  def absorb(damage: Double) = Math.max(0, damage - absorption)
}

trait RechargeableShield extends Shield {
  override def walk(kms: Int): Unit = {
    absorption += kms * 10
    super.walk(kms)
  }
}

trait ReflectionDamage extends Character{

  val reflection: Double = 0.0

  override def receiveHit(damage: Double,other: Character): Unit = {
     val damageToReflect = damage * reflection
     other.receiveHit(damageToReflect,other)
     super.receiveHit(damage,other)
  }
}

trait DamageAbsorption extends Character with PowerAttack {

  val absorption: Double = 0.0 // ej 15% = 0.15

  override def receiveHit(damage: Double,other: Character): Unit = {
    powerAttack += damage * absorption
    super.receiveHit(damage,other)
  }
}
