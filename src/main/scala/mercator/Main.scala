package mercator

object Main extends App {
  val offers: Map[ShoppingItem, Offer] = Map(
    Apple -> BuyOneGetOneFree,
    Orange -> ThreeForTwo
  )

  val checkoutSystem = new CheckoutSystem(offers)

  val items =
    List.fill(5)(Apple) ++ List.fill(7)(Orange)

  val total = checkoutSystem.checkout(items)

  println(s"Total to pay: £$total")
}


