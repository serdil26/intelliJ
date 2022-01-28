package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    //amazon ana sayfaya gidin
    // sag ustte hello, sign elementinin uzerinde mouse'i bekletin
    //acilan menude new list linkine tikalyin
    //ve new list sayfasinin acildigini test edin

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
       WebElement hello=  driver.findElement(By.id("nav-link-accountList-nav-line-1"));
       actions.moveToElement(hello).perform();
   WebElement list= driver.findElement(By.xpath("//span[text()='Create a List']"));
   actions.click(list).perform();

        WebElement lists =driver.findElement(By.xpath("//span[text()='Lists']"));
        Assert.assertTrue(lists.isDisplayed());


    }
}
