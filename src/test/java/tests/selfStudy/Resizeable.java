package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Resizeable extends TestBase {
    @Test
    public void resizableTest() throws InterruptedException {
        driver.get("https://demoqa.com/resizable");
        WebElement resize= driver.findElement(By.xpath("//span[@class='react-resizable-handle react-resizable-handle-se']"));

        Actions action= new Actions(driver);
        action.dragAndDropBy(resize, 472,284).perform();
        Thread.sleep(3000);


    }
}
