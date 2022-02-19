package tests.practice;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class DataProvider3 extends TestBase {
    //https://www.gmibank.com/ adresine gidip negative login test yapiniz..
    // test datalar :
//{"username1@gmail.com","password1"},
//{"username2@gmail.com","password2"},
    @Test (dataProvider = "negativeSigninTest")
    public void bankaLogin(String user, String pass){
        driver.get("https://www.gmibank.com");
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @DataProvider
    public static Object[][] negativeSigninTest(){
        Object[][] bankData=new Object[3][2];
        bankData[0][0]= "username1@gmail.com";
        bankData[0][1]= "password1";
        bankData[1][0]= "username2@gmail.com";
        bankData[1][1]= "password2";
        bankData[2][0]= "username3@gmail.com";
        bankData[2][1]= "password3";

        return bankData;
    }

}
