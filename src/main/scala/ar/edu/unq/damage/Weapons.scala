package ar.edu.unq.damage

import ar.edu.unq.normans.Character

trait Attack extends Character {
  private var _powerAttack: Double = 0.0
  def powerAttack = _powerAttack
  def powerAttack_= (power: Double) = _powerAttack = power
  def attack(other: Character): Unit = {
    other.receiveHit(powerAttack)
  }
}

trait Laser extends Attack {
  var _powerAttack: Double = 10.0
  override def powerAttack = _powerAttack + super.powerAttack

  override def attack(other: Character): Unit = {
    super.attack(other)
    _powerAttack = Math.max(1, _powerAttack - 1)
  }
}

trait FireGun extends Attack {
  var bullets: Int = 0
  private val _powerAttack: Double = 3.0

  override def powerAttack = effectivePower + super.powerAttack

  def effectivePower: Double = if (bullets > 0) _powerAttack else 0

  override def attack(other: Character): Unit = {
    super.attack(other)
    bullets = Math.max(0, bullets - 1)
  }
}

trait RareWeapon extends Attack {
  val damage: Double = 0.0
  override def powerAttack = damage + super.powerAttack

  override def attack(other: Character): Unit = {
    super.attack(other)
    energy = Math.max(0, energy - damage)
  }
}

trait Duplicators extends Attack{

  override def powerAttack: Double = super.powerAttack * 2

}

trait Enhancers extends Attack{}