package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import java.time.Duration;

public class MainPage extends BaseTest {
    private AppiumDriver driver;

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Yardımcı metod: Elemanı bekleyip tıklamak
    private void waitAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // İzin penceresindeki "Allow" butonuna tıklama(negatif senaryoda kullanilacak)
    @Test
    public void clickAllowPermissionButton() {
        waitAndClick(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    }

    // İzin penceresindeki "Deny" butonuna tıklama
    @Test
    public void clickDenyPermissionButton() {
        waitAndClick(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]"));
    }

    // Hoş geldiniz ekranında "Araç Şarjı" seçeneğine tıklama
    @Test
    public void clickSelectVehicle() {
        waitAndClick(By.xpath("//android.view.ViewGroup[@content-desc='Araç Şarjı']"));
    }

    // "Devam Et" butonuna tıklama
    @Test
    public void clickContinueButton() {
        waitAndClick(By.xpath("//android.view.ViewGroup[@content-desc='Devam Et']"));
    }

    // Tanıtım ekranındaki "Atla" butonuna tıklama
    @Test
    public void clickSkipIntroduction() {
        waitAndClick(By.xpath("//android.widget.TextView[@text=\"Atla\"]"));
    }

    // "Bir Daha Gösterme" butonuna tıklama
    @Test
    public void clickDoNotShowAgain() {
        WebElement doNotShowAgainButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Bir Daha Gösterme']"));
        sleep(2000); // 2 saniye bekle
        doNotShowAgainButton.click();
    }

    // Pop-up'ı kapama
    @Test
    public void closePopUp() {
        sleep(1000);
        WebElement popUp = driver.findElement(By.xpath("//android.widget.TextView[@text=\"\uE90F\"]"));
        popUp.click();
    }
}
