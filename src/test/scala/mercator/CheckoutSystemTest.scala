package mercator

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CheckoutSystemTest extends AnyWordSpec with Matchers {

  val checkoutSystem = new CheckoutSystem

  "CheckoutSystem" should {
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

}
