package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {
  // 1- Yeni bir class olusturalim: MouseActions1






    @Test
    public void test(){
        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //         3- Cizili alan uzerinde sag click yapalim
        Actions actions= new Actions(driver);
        WebElement box= driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
       String actualText= driver.switchTo().alert().getText();
        String expectedText= "You selected a context menu";
        Assert.assertEquals(actualText, expectedText);
        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        String handleDegeri1= driver.getWindowHandle();
        // 6- Elemental Selenium linkine tiklayalim
        WebElement selenyumLink= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        actions.click(selenyumLink).perform();
        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> handleDegerleri= driver.getWindowHandles();
String handleDegeri2="";
        for (String each: handleDegerleri
             ) {
            if(!handleDegeri1.equals(each)){
                handleDegeri2=each;
            }
        }
        driver.switchTo().window(handleDegeri2);
     WebElement text = driver.findElement(By.tagName("h1"));
     String expectedText2="Elemental Selenium";
     Assert.assertEquals(text.getText(), expectedText2);


    }





}
