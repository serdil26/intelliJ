package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void handleWindow() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String windowHandleDegeri1= driver.getWindowHandle();
        System.out.println("ilk sayfanin window handle degeri: " + driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencere acilir
        driver.get("https://www.bestbuy.com");
        String windowHandleDegeri2= driver.getWindowHandle();
        System.out.println("yeni pencere window handle degeri; "+ driver.getWindowHandle());

        Set<String> handleDegerleriSet=driver.getWindowHandles();
        System.out.println(handleDegerleriSet);
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        //amazon sayfasina geri donun ve nutella aratin!

        driver.switchTo().window(windowHandleDegeri1);
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);

        //bestbuy acik olan sayfaya gidin ve title'in Best Buy icerdigini test edin
        driver.switchTo().window(windowHandleDegeri2);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        //facebook'un acik oldugu sayfaya gecin
        //ve url'nin https://www.facebook.com oldugunu test edin
        //eger acik olan pencerelerden sadece bir tanesinin window handle degeri bilinmiyorsa
        //once tum handle degerlerinin bir set'e koyariz

        handleDegerleriSet=driver.getWindowHandles();
        //bu soru icin su anda set'te 3 window handle degeri var
        //1 ve 2.sayfanin handle degerlerini biliyoruz
        //setimizde olup ilk 2 sayfa olmayan degeri 3.sayfanin handle degeri olacaktir

        String windowHandleDegeri3="";
        for (String each:handleDegerleriSet) {
            if(!(each.equals(windowHandleDegeri1) || each.equals(windowHandleDegeri2))){
                windowHandleDegeri3=each;
            }
        }
        System.out.println(windowHandleDegeri3);
        System.out.println(handleDegerleriSet);

        driver.switchTo().window(windowHandleDegeri3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        Thread.sleep(3000);
    }

    @AfterClass
    public void end(){
        driver.quit();
    }





}
