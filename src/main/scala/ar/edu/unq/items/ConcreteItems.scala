package ar.edu.unq.items

class Rock(volume: Int)
  extends InorganicItem(volume, volume * 2)
     with NonCompacting

class Ball(volume: Int)
  extends InorganicItem(volume, volume * 1.2)
     with Compacting

class Paper(volume: Int, compactPoints: Int)
  extends InorganicItem(volume, volume * 0.9)
     with SemiCompacting {
       override val cp: Int = compactPoints
}

class Plant(volume: Int, waterVolume: Int)
  extends OrganicItem(volume, volume * 0.6, waterVolume)