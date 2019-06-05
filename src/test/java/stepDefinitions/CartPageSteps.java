package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {
	
	TestContext testContext;
	 CartPage cartPage;
	 
	 public CartPageSteps(TestContext context) {
		 testContext=context;
		 cartPage=testContext.getPageObjectManager().getCartPage();
	 }
	 
	 @When("^move to checkout from mini cart$")
		public void move_to_checkout_from_mini_cart() throws Throwable {
			 cartPage.clickOn_Cart();
			 cartPage.clickOn_ContinueToCheckout(); 
		}


}
