package mercator

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CheckoutSystemTest extends AnyWordSpec with Matchers {

  "CheckoutSystem with no offers" should {
    val checkoutSystem = new CheckoutSystem(Map.empty)

    "return 0 if there are no items in the cart" in {
      checkoutSystem.checkout(List.empty) shouldBe 0
    }

    "return 0.6 given an apple" in {
      checkoutSystem.checkout(List(Apple)) shouldBe 0.6
    }

    "return 0.25 given an orange" in {
      checkoutSystem.checkout(List(Orange)) shouldBe 0.25
    }

    "return £2.05 given three apples and an orange" in {
      checkoutSystem.checkout(List(Apple, Apple, Orange, Apple)) shouldBe 2.05
    }
  }

  "CheckoutSystem with offers" should {
    val offers: Map[ShoppingItem, Offer] = Map(Apple -> BuyOneGetOneFree, Orange -> ThreeForTwo)
    val checkoutSystem = new CheckoutSystem(offers)

    "return 0 if there are no items in the cart" in {
      checkoutSystem.checkout(List.empty) shouldBe 0
    }

    "return 0.6 given an apple" in {
      checkoutSystem.checkout(List(Apple)) shouldBe 0.6
    }

    "return 0.25 given an orange" in {
      checkoutSystem.checkout(List(Orange)) shouldBe 0.25
    }

    "apply the offer on apples" in {
      val cart = List.fill(7)(Apple)

      checkoutSystem.checkout(cart) shouldBe 2.4
    }

    "apply the offer on oranges" in {
      val cart = List.fill(7)(Orange)

      checkoutSystem.checkout(cart) shouldBe 1.25
    }
  }

}
