package ar.edu.unq.items

class Rock(volume: Int, mass: Double = 0.0)
  extends InorganicItem(volume, mass, energy = volume * 2)
     with NonCompaction

class Ball(volume: Int, mass: Double = 0.0)
  extends InorganicItem(volume, mass, energy = volume * 1.2)
     with Compaction

class Paper(volume: Int, mass: Double = 0.0)
  extends InorganicItem(volume, mass, energy = volume * 0.9)
     with SemiCompaction

class Plant(volume: Int, mass: Double = 0.0, waterVolume: Int)
  extends OrganicItem(volume, mass, volume * 0.6, waterVolume)
     with NonCompaction