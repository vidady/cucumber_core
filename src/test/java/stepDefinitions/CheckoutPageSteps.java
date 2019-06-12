package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.CheckoutPage;

public class CheckoutPageSteps {
	
	TestContext testContext;
	 CheckoutPage checkoutPage;
	 
	 public CheckoutPageSteps(TestContext context) {
		 testContext=context;
		 checkoutPage=testContext.getPageObjectManager().getCheckoutPage();
	 }
	 
	 
	 
		@When("^enter personal details on checkout page$")
		public void enter_personal_details_on_checkout_page() throws Throwable {
			 checkoutPage.fill_PersonalDetails();	
			 }

		@When("^select same delivery address$")
		public void select_same_delivery_address() throws Throwable {
			 checkoutPage.check_ShipToDifferentAddress(false);
		}

		@When("^select payment method as \"([^\"]*)\" payment$")
		public void select_payment_method_as_payment(String arg1) throws Throwable {
			 checkoutPage.select_PaymentMethod("CheckPayment");
		}

		@And("^place the order$")
		public void place_the_prder() throws Throwable {
			 checkoutPage.check_TermsAndCondition(true);
			 checkoutPage.clickOn_PlaceOrder();
			 
		}

}
