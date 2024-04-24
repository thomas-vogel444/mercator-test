package mercator

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OfferTest extends AnyWordSpec with Matchers {

  "Offer.applyOffer" should {
    "return 0 if the number of items is 0" in {
      Offer.applyOffer(BuyOneGetOneFree, 0) shouldBe 0
      Offer.applyOffer(ThreeForTwo, 0) shouldBe 0
    }

    "apply 'Buy One Get One Offer'" in {
      Offer.applyOffer(BuyOneGetOneFree, 1) shouldBe 1
      Offer.applyOffer(BuyOneGetOneFree, 2) shouldBe 1
      Offer.applyOffer(BuyOneGetOneFree, 3) shouldBe 2
      Offer.applyOffer(BuyOneGetOneFree, 7) shouldBe 4
      Offer.applyOffer(BuyOneGetOneFree, 11) shouldBe 6
    }

    "apply 'Three For Two'" in {
      Offer.applyOffer(ThreeForTwo, 1) shouldBe 1
      Offer.applyOffer(ThreeForTwo, 2) shouldBe 2
      Offer.applyOffer(ThreeForTwo, 3) shouldBe 2
      Offer.applyOffer(ThreeForTwo, 11) shouldBe 8
    }
  }
}
