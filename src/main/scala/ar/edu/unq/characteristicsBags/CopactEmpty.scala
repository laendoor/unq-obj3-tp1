package ar.edu.unq.characteristicsBags

import ar.edu.unq.bags.Bag


trait CopactEmpty {

  def compacting(bag: Bag){

    bag.items.foreach { arg =>  bag.volume -= arg.compact}
  }
}

trait BagDesidratacion{

  def compacting(bag: Bag){
    bag.items.foreach { arg =>
      if(arg.tipo == "organic"){
        bag.volume -= arg.desidratacion

      }

    }
  }

}


