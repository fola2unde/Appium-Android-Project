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
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:autoGrantPermissions", true);
        cap.setCapability("appium:deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("appium:udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:platformVersion", "15");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:appPackage", "org.simple.clinic.staging");
        cap.setCapability("appium:appActivity", "org.simple.clinic.setup.SetupActivity");

//Setup url connection to mobile
        URL url = new URL("http://127.0.0.1:4723/");

        driver = new AppiumDriver(url, cap);






    }



}









