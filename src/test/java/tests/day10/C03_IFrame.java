package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_IFrame {
    // Bir class olusturun: IframeTest


    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void iFrameTesti() {
        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // Bir metod olusturun: iframeTest
        WebElement istenenYazi = driver.findElement(By.tagName("h3"));
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(istenenYazi.isEnabled(), "iframe yazisi gorunmuyor!");
        System.out.println(istenenYazi);
        // Text Box’a “Merhaba Dunya!” yazin.

        //YAZI YAZMAK ISTEDIGIMIZ TEXT KUTUSU IFRAME'IN ICINDE OLDUGUNDA DIREKT ULASAMIYORUZ
        //ONCE IFRAMI'I LOCATE EDIP ONUN ICINE SWITCH YAPMALIYIZ'
        WebElement iFrame= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Hello Dunya!");
        //         TextBox’in altinda bulunan “Elemental Selenium” linkini tiklayin ve yeni acilan sayfada

        //FRAME'IN ICINDE OLDUGUMUZ ICIN GERI DONMEK ICIN switchTo().parentFrame() yapmamiz gerekir
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
//       "Sponsored by Sauce Labs"  textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
        WebElement sponsoredYazisi= driver.findElement(By.xpath("//p[text()='Sauce Labs']"));
        softAssert.assertTrue(sponsoredYazisi.isDisplayed(), "sponsored yazisi gorunmuyor");
        softAssert.assertAll();
    }
    @AfterClass
    public void end(){
        driver.quit();
    }
}
