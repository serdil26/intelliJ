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

public class C01_Alerts {
    //     Bir class olusturun: Alerts

//    Bir metod olusturun: acceptAlert
// Bir metod olusturun: dismissAlert

//  Bir metod olusturun: sendKeysAlert

    WebDriver driver;
    WebElement sonucYazisiElementi;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
   driver= new ChromeDriver();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlertTesti(){
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının


        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
//    “You successfully clicked an alert” oldugunu test edin.
        sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }
    @Test
    public void dismissAlertTesti(){
//    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        //    “successfuly” icermedigini test edin.
        sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String unexpectedSonucYazisi="successfuly";
        Assert.assertFalse(actualSonucYazisi.contains(unexpectedSonucYazisi));

    }
    @Test
    public void sendKeysTesti(){
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("sezgin");
        //    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
//    OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().accept();
        sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualYazi=sonucYazisiElementi.getText();
        String expectedYazi="sezgin";
        Assert.assertTrue(actualYazi.contains(expectedYazi));



    }

    @AfterClass
    public void end(){
        driver.quit();

    }





}
