package ar.edu.unq.combat

import ar.edu.unq.normans.Character

class Combat(red: Character, blue: Character) {

  def isLife(character: Character): Boolean = {character.energy > 0}

  def combat(): Unit = {
    blue.attack(red)
    red.attack(blue)
  }

  def ataqueTotal(): Unit = {
     while (this.isLife(blue) ||  this.isLife(red)){
         combat()
     }
  }

  def winner(): Character = {
    if (isLife(blue)) {blue} else {red}
  }


}
