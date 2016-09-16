package ar.edu.unq.combat

import ar.edu.unq.normans.Character

class Combat(white: Character, black: Character) {

  def start(): Unit = while (isNotOver) roundFight()

  def roundFight(): Unit = {
    if (white.isAlive) white attack black
    if (black.isAlive) black attack white
  }

  def isNotOver = bothAlive //|| bothWithPowerAttack
  def bothAlive: Boolean = black.isAlive && white.isAlive
//  def bothWithPowerAttack: Boolean = black.hasPowerAtack && white.hasPowerAttack

  def winner(): Character = List(white, black).maxBy(_.energy)

}
