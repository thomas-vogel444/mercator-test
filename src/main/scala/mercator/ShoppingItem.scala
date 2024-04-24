package mercator

sealed trait ShoppingItem {
  val price: Double
}
case object Apple extends ShoppingItem { val price: Double = 0.6 }
case object Orange extends ShoppingItem { val price: Double = 0.25 }
