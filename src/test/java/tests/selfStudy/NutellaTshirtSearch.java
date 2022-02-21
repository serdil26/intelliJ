package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class NutellaTshirtSearch extends TestBase {

    @Test
    public void nutella() throws InterruptedException {
        //go to amazon.fr
        //search for nutella capuche
        //choose the 4th image and click on it
        //Select the size
        //add to shopping list
        //verify that it's added to list

        driver.get("https://www.amazon.fr");

      driver.findElement(By.xpath("//span[@class='a-button a-button-primary']")).click();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("sweat a capuche nutella" + Keys.ENTER);

        driver.findElement(By.xpath("//img[@data-image-index='4']")).click();
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']"));
        Select select= new Select(dropDown);
        select.selectByIndex(3);
        Thread.sleep(3000);
        driver.findElement(By.id("add-to-cart-button")).click();

        String actualText= driver.findElement(By.xpath("//*[@id=\"sw-atc-details-single-container\"]/div[2]/div[1]/span")).getText();
        String expectedText= "Ajouté au panier";
        Assert.assertEquals(actualText, expectedText);
    }

}
