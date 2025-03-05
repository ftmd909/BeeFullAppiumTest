package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppiumCapabilities {
    public static DesiredCapabilities getCapabilities() throws IOException {
        // config.properties dosyasını okuyalım
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
        properties.load(inputStream);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", properties.getProperty("platformName"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
        capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
        capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
        capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
        capabilities.setCapability("automationName", properties.getProperty("automationName"));

        return capabilities;
    }
}
