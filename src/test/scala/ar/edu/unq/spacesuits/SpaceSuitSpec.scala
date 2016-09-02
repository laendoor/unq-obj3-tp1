package ar.edu.unq.spacesuits

import ar.edu.unq.utils.BaseSpec

abstract class SpaceSuitSpec extends BaseSpec {

  val suit: SpaceSuit

  after {
    suit restoreOxygen()
  }

}