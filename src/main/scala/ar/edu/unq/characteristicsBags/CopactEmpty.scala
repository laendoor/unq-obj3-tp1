package ar.edu.unq.characteristicsBags

import ar.edu.unq.bags.Bag


trait CopactEmpty {

  def compacting(bag: Bag){

    bag.items.foreach { arg =>  bag.volume -= arg.compact}
  }
}

trait BagDehydration{

  def compacting(bag: Bag){
    bag.items.foreach { arg => bag.volume -= arg.Dehydration}
  }

}


