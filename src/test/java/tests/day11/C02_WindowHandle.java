package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {

WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void windowHandleTest(){
//● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//           ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textElementi= driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(textElementi.getText(),"Opening a new window", "sayfadaki yazi farkli");
//           ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        softAssert.assertEquals(actualTitle, "The Internet", "title beklenenden farkli");
        String windowHandleDegeri1= driver.getWindowHandle();
//           ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //ONCE ACILAN YENI SAYFANIN HANDLE DEGERINI ELDE ETMELIYIZ!
        //BUNU DA SET OLUSTURARAK YAPACAGIZ VE FOR EACH ILE ELIMIZDE OLMAYANI BULACAGIZ

        Set<String> handleDegerleriSeti=driver.getWindowHandles();
        String windowHandleDegeri2="";
        for (String each: handleDegerleriSeti) {
            if(!each.equals(windowHandleDegeri1)){
                windowHandleDegeri2=each;
            }

        }

//           ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(windowHandleDegeri2);
        softAssert.assertEquals(driver.getTitle(),"New Window", "yeni sayfa title'i farkli");

//           ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaTextEle= driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciSayfaTextEle.getText(),"New Window","ikinci sayfa texti farkli");
//           ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandleDegeri1);
        softAssert.assertEquals(driver.getTitle(),"The Internet","ilk sayfanin title'i beklenenden farkli");

        softAssert.assertAll();
    }
    @AfterClass
    public void end(){
        driver.quit();
    }








}
