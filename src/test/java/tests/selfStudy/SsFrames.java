package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class SsFrames extends TestBase {
    @Test
    public void test(){
        driver.get("https://demoqa.com/nestedframes");
        WebElement yazi= driver.findElement(By.id("framesWrapper"));
        System.out.println(yazi.getText());

        driver.switchTo().frame("frame1");
        WebElement parent= driver.findElement(By.tagName("body"));
        System.out.println(parent.getText());


        driver.switchTo().frame(0);
        WebElement child= driver.findElement(By.tagName("p"));
        System.out.println(child.getText());

        driver.switchTo().defaultContent();
        Assert.assertTrue(yazi.isDisplayed());



    }
}
