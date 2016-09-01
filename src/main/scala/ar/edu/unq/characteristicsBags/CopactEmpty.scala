package ar.edu.unq.characteristicsBags

import ar.edu.unq.bags.Bag


trait CopactEmpty {

  def compacting(bag: Bag) = {
    bag.items.foreach { item => item.compact}
  }
}

trait BagDehydration{

  def compacting(bag: Bag){
    bag.items.foreach { item => item.Dehydration }
  }

}



