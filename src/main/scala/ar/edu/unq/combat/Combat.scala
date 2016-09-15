package ar.edu.unq.combat

import ar.edu.unq.damage.Attack
import ar.edu.unq.normans.Character

object Combat {

//hacerlos combatir
//retorna el ganador



  def isLife(character: Character ): Boolean = {character.energy >= 0}

  def combat(character1: Character,character2: Character): Unit ={

    character1.attack(character2)
    character2.attack(character1)
  }

  def winner(character1: Character,character2: Character): Character = {

    if (isLife(character1)) {character1} else {character2}
  }

  def ataqueTotal(character1: Character , character2: Character): Character = {
    var c1= character1
    var c2= character2

     while (this.isLife(c1) ||  this.isLife(c2)){

         this.combat(c1,c2)
     }
   this.winner(c1,c2)
  }


}
