
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
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.google.android.dialer");
        caps.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    @Test
    public void click_test() {
        driver.findElement(By.id("dialpad_fab")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("one")).click();
        driver.findElement(By.id("two")).click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
