package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class gununSorusu11 extends TestBase {
     /*
     go to url :http://demo.guru99.com/popup.php
      get the first window
      clicking on click here button
      get all the window in the set
      switch to window
      input email id (somepne@gmail.com) and type something in that input
      Clicking on the submit button
      verify title as expected
      switch to first window
 */
    @Test
    public void test(){
        //go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        //get the first window
        String ilkPencere= driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
       //clicking on click here button get all the window in the set
       Set<String> windowsHandles= driver.getWindowHandles();
       String ikinciPencere="";
        for (String each:windowsHandles
             ) {
            if (!each.equals(windowsHandles)){
                ikinciPencere=each;
            }

        }
       // switch to window
        driver.switchTo().window(ikinciPencere);
        //input email id (somepne@gmail.com) and type something in that input
        //      Clicking on the submit button
        WebElement email= driver.findElement(By.name("emailid"));
        email.sendKeys("somepne@gmail.com"+ Keys.ENTER);

        String actualTitle= driver.getTitle();
       String expectedTitle= "Guru99 Bank Home Page";
       Assert.assertEquals(actualTitle, expectedTitle, "its not the expected title");
       // switch to first window
       driver.switchTo().window(ilkPencere);

    }
}
