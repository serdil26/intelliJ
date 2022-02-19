package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void facebookKayitTesti(){
//       "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

//create new account”  butonuna basin
        Actions actions=new Actions(driver);
        WebElement cookies= driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']"));
        cookies.click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

//firstName” giris kutusuna bir isim yazin
        WebElement ad= driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        Faker faker= new Faker();
        String email= faker.internet().emailAddress();

        actions.click(ad).sendKeys(faker.name().name()).
//surname” giris kutusuna bir soyisim yazin
        sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
//email” giris kutusuna bir email yazin
        sendKeys(Keys.TAB).sendKeys(email).
//email” onay kutusuna emaili tekrar yazin
        sendKeys(Keys.TAB).sendKeys(email).
//       Bir sifre girin
        sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
//       Tarih icin gun secin
        sendKeys(Keys.TAB).
        sendKeys(Keys.TAB).sendKeys("24").


//       Tarih icin ay secin
        sendKeys(Keys.TAB).sendKeys("Mar").
//       Tarih icin yil secin
        sendKeys(Keys.TAB).sendKeys("2000").
//       Cinsiyeti secin
        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
//       Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement erkekSecim= driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadinSecim=driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertTrue(erkekSecim.isSelected());
        Assert.assertFalse(kadinSecim.isSelected());


//       Sayfayi kapatin
    }
}
