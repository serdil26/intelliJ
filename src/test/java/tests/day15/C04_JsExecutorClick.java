package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecutorClick extends TestBase {
    //amazon anasayfaya gidip sell linkine tiklayalim
    //ilgili sayfaya gittigimizi test edelim

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        //1.ADIM Jsexecutor objesi olusturalim ve driver'a cast edelim
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //2.ADIM ilgili webelementi locate edelim
        WebElement sellElementi= driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        //3.ADIM ilgili script ve argument(buldugumuz webelement) ile objemiz uzerinden
        //executeScript methodunu calisitralim

        jse.executeScript("arguments[0].click();",sellElementi);



    }
}
