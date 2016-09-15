package ar.edu.unq.damage

import ar.edu.unq.normans.Character

trait Shield extends Character {
  var absorption: Double = 0.0

  override def receiveHit(damage: Double): Unit = {
    val effectiveDamage = this absorb damage
    absorption = Math.max(0, absorption - damage)
    super.receiveHit(effectiveDamage)
  }

  def absorb(damage: Double) = Math.max(0, damage - absorption)
}

trait RechargeableShield extends Shield {
  override def walk(kms: Int): Unit = {
    absorption += kms * 10
    super.walk(kms)
  }
}

// Reflector de daño: esta capacidad no afecta el daño recibido,
// pero inflige un porcentaje del daño recibido al atacante.
// Por ejemplo un Reflector de 5%, cuando recibe un daño
// de 100 puntos, inflige automáticamente 5 puntos al
// atacante (ese daño también deberá pasar como un
// ataque normal, con lo cual si el atacante
// también tiene escudo o alguna otra
// característica se tendrá en cuenta).
trait ReflectionDamage extends Character with Attack{

  val reflection: Double = 0.0
 // private  var damageToReflect: Double = 0.0

 // override def powerAttack =  damageToReflect//super.powerAttack
/*
  override def attack(other: Character): Unit = {
    super.attack(other)
  }
*/
  override def receiveHit(damage: Double,other: Character): Unit = {
     val damageToReflect = damage * reflection
    other.receiveHit(damageToReflect)

    super.receiveHit(damage)
  }
}

// Absorción de daño: esta característica permite convertir el daño en
// poder de ataque. En base a un factor. Es decir, si nos infligen 20
// puntos de daño y tenemos una capacidad de absorción de 0.15,
// entonces vamos a generar un incremento de 20 * 0.15 puntos
// de poder de ataque (ver siguiente punto sobre ataque)
trait DamageAbsorption extends Character with Attack {

  val absorption: Double = 0.0 // ej 15% = 0.15

  override def receiveHit(damage: Double): Unit = {
    powerAttack += damage * absorption
    super.receiveHit(damage)
  }
}
