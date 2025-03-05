package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

public class LoginPage extends BaseTest {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }
    private static final By PHONE_NUMBER_FIELD = By.xpath("//android.widget.EditText[@text=\"Phone Number\"]");
    private static final By CONTINUE_BUTTON = By.xpath("//android.widget.TextView[@resource-id='button-title']");

    public void enterPhoneNumberAndContinue(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Telefon numarası alanını bul ve t,kla
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_NUMBER_FIELD));
        phoneNumberField.click();

        // Telefon numarasını girisi yapiliyor
        phoneNumberField.sendKeys(phoneNumber);
        sleep(2000);
        // Devam Et butonunu bul ve tikla
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(CONTINUE_BUTTON));
        continueButton.click();
        sleep(20000); //otp giris süresi
    }
}
