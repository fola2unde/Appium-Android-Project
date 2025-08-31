import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {

    static AppiumDriver driver;


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        openMobileApp();
    }

    public static void openMobileApp() throws MalformedURLException, InterruptedException {
//Pass desired capabilities here:
        DesiredCapabilities cap = getDesiredCapabilities();

//Setup url connection to mobile
        URL url = new URL("http://127.0.0.1:4723/");

        driver = new AppiumDriver(url, cap);

//Pass elements
        Thread.sleep(2000);
        driver.findElement(new By.ByXPath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]\n")).click();
        String actualSearchFind = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/introOneTextView\")")).getText();
        Assertions.assertEquals("""
                Search & find\s
                thousands of patients\s
                with hypertension""", actualSearchFind);
        String actualRecord = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/introTwoTextView\")")).getText();
        Assertions.assertEquals("""
                Maintain records of\s
                blood pressures\s
                & medicines""", actualRecord);

        driver.findElement(new By.ByXPath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/getStartedButton\"]\n")).click();
        String actualTermPage = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Terms of Use\")")).getText();
        Assertions.assertEquals("Terms of Use", actualTermPage);
        driver.findElement(new By.ByXPath("//android.widget.Button\n")).click();

    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:autoGrantPermissions", true);
        cap.setCapability("appium:deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("appium:udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:platformVersion", "15");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:appPackage", "org.simple.clinic.staging");
        cap.setCapability("appium:appActivity", "org.simple.clinic.setup.SetupActivity");
        return cap;
    }


}









