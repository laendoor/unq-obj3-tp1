package ar.edu.unq.items

class Rock(volume: Int, mass: Double = 0.0)
  extends InorganicItem(volume, mass, energy = volume * 2)
     with NonCompacting

class Ball(volume: Int, mass: Double = 0.0)
  extends InorganicItem(volume, mass, energy = volume * 1.2)
     with Compacting

class Paper(volume: Int, mass: Double = 0.0, compactPoints: Int)
  extends InorganicItem(volume, mass, energy = volume * 0.9)
     with SemiCompacting {
       override val cp: Int = compactPoints
}

class Plant(volume: Int, mass: Double = 0.0, waterVolume: Int)
  extends OrganicItem(volume, mass, volume * 0.6, waterVolume)