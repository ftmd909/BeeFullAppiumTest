package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class NearestStationsListPage extends BaseTest {
    private AppiumDriver driver;

    public NearestStationsListPage(AppiumDriver driver) {
        this.driver = driver;
    }

    //en yakın istasyon butonuna tıklar
    @Test
    public void clickNearestStation() {
        WebElement button = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"En Yakın İstasyon\"]"));
        button.click();
    }

    // En yakın istasyonlar listelendi mi diye kontrol eder
    @Test
    public boolean isNearestStationsListed() {
        try {
            WebElement reservation = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Rezervasyon\"]"));
            return reservation.isDisplayed(); // Eğer "Rezervasyon" öğesi görünüyorsa, istasyonlar listelenmiş demektir.
        } catch (Exception e) {
                Assert.fail("En yakın istasyonlar listelenmedi.");
            return false; // "Rezervasyon" öğesi bulunamazsa, istasyonlar listelenmemiştir.
        }
    }
}