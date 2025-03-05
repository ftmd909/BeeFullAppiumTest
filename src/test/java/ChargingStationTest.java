import Pages.LoginPage;
import Pages.MainPage;
import Pages.NearestStationsListPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ChargingStationTest extends BaseTest {

    @Test
    public void testChargingStation() {

        MainPage mainPage = new MainPage(driver);
        NearestStationsListPage nearestStationsList = new NearestStationsListPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Konum izni butonuna tıklıyoruz
        mainPage.clickAllowPermissionButton();  // Konum izni verildi

        // "Araç Şarjı" öğesine tıklama
        mainPage.clickSelectVehicle();

        // Devam Et butonuna tıklıyoruz
        mainPage.clickContinueButton();

        // Tanıtımı atla
        mainPage.clickSkipIntroduction();

        // Telefon numarasını gir ve devam et
        loginPage.enterPhoneNumberAndContinue("YOUR_PHONE");

        // "Do not show again" seçeneği ve pop-up'ı kapat
        mainPage.clickDoNotShowAgain();

        // E-posta doğrulama uyarı PopUp Kapatma
        mainPage.closePopUp();

        // En yakın istasyon butonuna tıklıyoruz
        nearestStationsList.clickNearestStation();

        // En yakın istasyonların listelendiğini doğrula
        nearestStationsList.isNearestStationsListed();
    }
}
