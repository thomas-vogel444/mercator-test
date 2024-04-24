package mercator

class CheckoutSystem(offers: Map[ShoppingItem, Offer]) {
  def checkout(items: List[ShoppingItem]): Double =
    items.groupBy(identity).view.mapValues(_.size)
      .map { case (item, size) =>

        val numberItemsToBeCharged =
          offers.get(item)
            .map(Offer.applyOffer(_, size))
            .getOrElse(size)

        numberItemsToBeCharged * item.price
      }.sum
}

