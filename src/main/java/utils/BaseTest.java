package utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() throws Exception {
        // DesiredCapabilities'i AppiumCapabilities sınıfından alıyoruz
        DesiredCapabilities capabilities = AppiumCapabilities.getCapabilities();

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), capabilities);
            System.out.println("Driver initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Driver initialization failed.");
        }
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed successfully.");
        }
    }
}
