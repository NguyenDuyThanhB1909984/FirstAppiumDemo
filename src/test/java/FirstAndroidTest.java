package Android;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class FirstAndroidTest {
    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
//        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app",
                System.getProperty("user.dir") + "/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    @Test
    public void click_test() {
        driver.findElement(By.id("fab")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
