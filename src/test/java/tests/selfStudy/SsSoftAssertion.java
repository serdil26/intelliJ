package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SsSoftAssertion {


    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void arama() {
        //1. “https://www.hepsiburada.com/” Adresine gidin
        driver.get("https://www.hepsiburada.com/");
        //           2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedTitle="Turkiye’nin En Buyuk Alisveris Sitesi";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle,"Baslik beklenen cumleyi icermiyor");

        //           3. search kutusuna araba yazip arattirin
        WebElement searchBox= driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        searchBox.sendKeys("araba"+ Keys.ENTER);
        //  4. bulunan sonuc sayisini yazdirin
        WebElement sonucElementi= driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-mainText']"));
        System.out.println("Sonuc sayisi ="+sonucElementi.getText() );

        //  5. sonuc yazisinin "araba" icerdigini dogrulayin
        String actualText= sonucElementi.getText();
        String expectedText="araba";
        softAssert.assertTrue(actualText.contains(expectedText),"araba icermiyor");
        //  6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        String unexpectedText="oto";
        softAssert.assertFalse(actualText.contains(unexpectedText),"oto iceriyor");
        softAssert.assertAll();
    }
    @AfterMethod
    public void end(){
        driver.close();
    }


    }





