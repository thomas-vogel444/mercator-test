package mercator

class CheckoutSystem {
  def checkout(items: List[ShoppingItem]): Double =
    items.map(_.price).sum
}

