package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BasicAuthentication {
  //  1- Bir class olusturun : BasicAuthentication


    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void authenticationTesti(){
        // 2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
      //  driver.get("https://the-internet.herokuapp.com/basic_auth");
        //          3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //  Html komutu : https://username:password@URL
        //  Username     : admin
        //  password      : admin
        //BASIC AUTHENTICATION isteyen web servisleri bize nasil ve hangi bilgilerle authentication
        //yapabilecigimiz bilgisini de vermek zorundadir. biz de bize tarif edilen yontem ve bilgileri uygulayarak
                //istedigimiz web servise giris saglayabiliriz
      driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //  4 - Basarili sekilde sayfaya girildigini dogrulayin
        WebElement girisMesajiElementi= driver.findElement(By.tagName("p"));
        Assert.assertTrue(girisMesajiElementi.isDisplayed());
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }








}
