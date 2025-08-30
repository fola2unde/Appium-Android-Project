package stepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;


public class DemoHCApp {
    static AppiumDriver driver;


    @Given("User navigates to the Health app")
    public void User_navigates_to_the_Health_app() throws InterruptedException {
//Pass elements
        Thread.sleep(2000);
        driver.findElement(new By.ByXPath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]\n")).click();
        String actualSearchFind = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/introOneTextView\")")).getText();
        Assertions.assertEquals("Search & find \n" +
                "thousands of patients \n" +
                "with hypertension", actualSearchFind);
        String actualRecord = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/introTwoTextView\")")).getText();
        Assertions.assertEquals("Maintain records of \n" +
                "blood pressures \n" +
                "& medicines", actualRecord);

    }
    @When("he clicks on the next pages")
    public void he_clicks_on_the_next_pages(){
        driver.findElement(new By.ByXPath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/getStartedButton\"]\n")).click();
        String actualTermPage = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Terms of Use\")")).getText();
        Assertions.assertEquals("Terms of Use", actualTermPage);


    }
    @Then("he successfully navigate to and validate the app")
    public void he_successfully_navigates_to_and_validate_the_app(){
        driver.findElement(new By.ByXPath("//android.widget.Button\n")).click();
    }
}
