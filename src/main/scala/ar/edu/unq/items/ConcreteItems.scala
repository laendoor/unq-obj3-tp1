package ar.edu.unq.items

class Rock(volume: Int) extends InorganicItem(volume)
  with NonCompacting

class Ball(volume: Int) extends InorganicItem(volume)
  with Compacting

class Paper(volume: Int, compactPoints: Int) extends InorganicItem(volume)
  with SemiCompacting {
  override val cp: Int = compactPoints
}

class Plant(volume: Int, waterVolume: Int) extends OrganicItem(volume, waterVolume)