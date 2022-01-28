package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class SS2 {
    //https://demoqa.com/links adresine gidin
    //sayfa basliginin ToolsQA oldugunu kontrol edein
    //home linkini tiklayi ve acilan yeni sekmeye gidin
    //yeni acilan sekmedeki title'in ToolsQA oldugunu kontrol edin
    //ilk sayfaya geri donun ve pencereleri kapatin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/links");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"ToolsQA", "titlelar esit degil");
        String ilkSayfaHandle= driver.getWindowHandle();
        driver.findElement(By.id("simpleLink")).click();


       Set<String> sayfalarHandles=driver.getWindowHandles();
      String ikinciSayfahandle="";
        for (String each:sayfalarHandles
             ) {
         if(!ilkSayfaHandle.equals(ikinciSayfahandle)){
             ikinciSayfahandle=each;
         }

        }
        driver.switchTo().window(ikinciSayfahandle);
        softAssert.assertEquals(driver.getTitle(), "ToolsQA", "titlelar esit degil");

        driver.switchTo().window(ilkSayfaHandle);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
