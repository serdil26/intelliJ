package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;
    @BeforeMethod
            public void setup(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

@Test
    public void dropdownTesti() throws InterruptedException {
//dropdownda var olan seceneklerden birini secmek icin
// 1.ADIM >dropdown web elementini locate edip bir degiskene atiyoruz

        WebElement dropdownElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    //2.ADIM> select classindan bir obje olusturalim ve parametre olarak locate ettigimiz web elementi yazalim
        Select select= new Select(dropdownElementi);

        //3.ADIM> select objesini kullanarak select class'indan var olan 3 secim metodundan
        //istedgimizi kullanarak dropdown'da var olan option'lardan birini secebiliriz
        //secim yapmamiza yardim eden bu 3 metod VOID'dir dolayisiyla bize birsey dondurmezler
        select.selectByIndex(3);
        //eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        select.selectByValue("search-alias=arts-crafts-intl-ship");
    Thread.sleep(3000);

    select.selectByVisibleText("Beauty & Personal Care");
    Thread.sleep(3000);

    List<WebElement> optionList= select.getOptions();
    for (WebElement each: optionList
         ) {
        System.out.println(each.getText());
    }
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }





}
