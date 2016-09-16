package ar.edu.unq.damage

import ar.edu.unq.normans.Character

trait PowerAttack {
  private var _powerAttack: Double = 0.0
  def powerAttack = _powerAttack
  def powerAttack_= (power: Double) = _powerAttack = power
  def attack(other: Character) = {}
}

trait Laser extends PowerAttack {
  var _powerAttack: Double = 10.0
  override def powerAttack = _powerAttack + super.powerAttack

  override def attack(other: Character): Unit = {
    super.attack(other)
    _powerAttack = Math.max(1, _powerAttack - 1)
  }
}

trait FireGun extends PowerAttack {
  var bullets: Int = 0
  private val _powerAttack: Double = 3.0

  override def powerAttack = effectivePower + super.powerAttack

  def effectivePower: Double = if (bullets > 0) _powerAttack else 0

  override def attack(other: Character): Unit = {
    super.attack(other)
    bullets = Math.max(0, bullets - 1)
  }
}

trait RareWeapon extends PowerAttack {
  var energy: Double
  val damage: Double = 0.0
  override def powerAttack = damage + super.powerAttack

  override def attack(other: Character): Unit = {
    super.attack(other)
    energy = Math.max(0, energy - damage)
  }
}

/**
  * Attack Modifiers
  */

trait Duplicator extends PowerAttack {
  override def powerAttack: Double = super.powerAttack * 2
}

trait Enhancer extends PowerAttack {
  val enhancedPower: Double = 0.0
  override def powerAttack: Double = super.powerAttack + enhancedPower
}

trait Canceller extends PowerAttack {
  override def powerAttack: Double = 0.0
}

/**
  * Power Attacks by Characteristics
  */

trait Exhaustion extends PowerAttack {
  def fatigue: Double
  override def powerAttack = Math.max(0, super.powerAttack - fatigue)
}
