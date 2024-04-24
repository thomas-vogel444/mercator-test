package mercator

sealed trait Offer
case object BuyOneGetOneFree extends Offer
case object ThreeForTwo extends Offer

object Offer {
  def applyOffer(offer: Offer, numberOfItems: Int): Int =
    offer match {
      case BuyOneGetOneFree => numberOfItems / 2 + numberOfItems % 2
      case ThreeForTwo => numberOfItems - numberOfItems / 3
    }
}