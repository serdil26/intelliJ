package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {

   // 1- https://demoqa.com/droppable adresine gidelim
            // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
//3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    @Test
    public void test(){
        driver.get("https://demoqa.com/droppable");
        WebElement drag= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
      // WebElement actualText= driver.findElement(By.xpath("//p[text()='Dropped!']")); her iki sekilde de olabilir(bir alttaki satir ya da bu satir)
        String actualText= drop.getText();
       String expectedText="Dropped!";
        Assert.assertEquals(actualText, expectedText);




    }

}
