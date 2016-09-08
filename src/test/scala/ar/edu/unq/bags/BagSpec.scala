package ar.edu.unq.bags

import ar.edu.unq.bags.compaction._
import ar.edu.unq.bags.resistance._
import ar.edu.unq.utils.BaseSpec

class BagSpec extends BaseSpec
  with SmallBagSpec
  with MediumBagSpec
  with LargeBagSpec
  with DehydrationSpec
  with VacuumCompactionSpec
  with RegularSpec
  with RigidSpec
  with SemiRigidSpec
