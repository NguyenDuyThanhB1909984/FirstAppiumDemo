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
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class FirstAndroidTest {
    AppiumDriver driver;
    public void screenshot(String path_screenshot) throws IOException {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        String filename= UUID.randomUUID().toString();
        File targetFile=new File(path_screenshot + filename +".png");
        FileUtils.copyFile(srcFile, targetFile);
            }
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
        screenshot(System.getProperty("user.dir") + "/report/")
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        screenshot(System.getProperty("user.dir") + "/report/")
    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
