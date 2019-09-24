package stepDefinitions;

import org.junit.Assert;

import Basictest.BasicTest;
import Basictest.CommonSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step extends BasicTest{

	BasicTest basictest;
	CommonSteps commonsteps;
	@Given("^User is on \"([^\"]*)\"$")
	public void user_is_on_login_page(String propvalue) {
		System.out.println(prop.get(propvalue));
		boolean status = BasicTest.initialize(propvalue);
		Assert.assertTrue("Driver is unable to launch the browser", status);    
	}

	@When("^User enter the \"([^\"]*)\"$")
	public void user_enter_the(String propvalue) throws InterruptedException{
	   System.out.println(prop.getProperty(propvalue));
	   boolean status=CommonSteps.enterValue(propvalue);
	   Assert.assertTrue("failed to enter the value ", status);
	}

	@When("^User click on \"([^\"]*)\"$")
	public void user_click_on_$Submit(String propvalue) throws Throwable {
		System.out.println(prop.getProperty(propvalue));
		boolean status=CommonSteps.commonClick(propvalue);
		Assert.assertTrue("failed to clicl on the button", status);
	}

	@Then("^user verify the \\$HomePage$")
	public void user_verify_the_$HomePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^user close the browser$")
	public void user_close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

	
	
}
