package mercator

import scala.collection.MapView

class CheckoutSystem(offers: Map[ShoppingItem, Offer]) {
  def checkout(items: List[ShoppingItem]): Double = {
    val cart: MapView[ShoppingItem, Int] = items.groupBy(identity).view.mapValues(_.size)

    cart
      .map { case (item, numberInCart) => numberItemsToBeCharged(item, numberInCart) * item.price }
      .sum
  }

  private def numberItemsToBeCharged(item: ShoppingItem, numberInCart: Int): Int =
    offers.get(item)
      .map(Offer.applyOffer(_, numberInCart))
      .getOrElse(numberInCart)
}

