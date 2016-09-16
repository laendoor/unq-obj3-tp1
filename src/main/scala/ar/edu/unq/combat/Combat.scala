package ar.edu.unq.combat

import ar.edu.unq.normans.Character

class Combat(white: Character, black: Character) {

  /** A fight gives 3 exp point to winner and 1 to looser */
  def fight(): Unit = {
    while (isNotOver) roundFight()

    white.xp += 1
    black.xp += 1
    winner().xp += 2
  }

  def roundFight(): Unit = {
    if (white.isAlive) white attack black
    if (black.isAlive) black attack white
  }

  def isNotOver = bothAlive && bothWithPowerAttack
  def bothAlive: Boolean = black.isAlive && white.isAlive
  def bothWithPowerAttack: Boolean = black.hasPowerAttack && white.hasPowerAttack

  def winner(): Character = List(white, black).maxBy(_.energy)

}
