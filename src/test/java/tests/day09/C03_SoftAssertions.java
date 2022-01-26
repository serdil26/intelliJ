package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertions {

    @Test
    public void test(){
        int a=10;
        int b=20;
        int c=30;
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(a,b,"birinci test basarisiz"); //failed
        softAssert.assertTrue(a>b,"ikinci test basarisiz"); //failed
        softAssert.assertTrue(a<c,"ucuncu test basarisiz"); // passed
        softAssert.assertTrue(c>b,"dorduncu test basarisiz"); //passed
        softAssert.assertTrue(c<a,"besinci test basarisiz");//failed

        //assertAll demezsek class calisir ve pass yazar
        //softassert tek basina raporlama yapmaz sadece class calismis olur
        softAssert.assertAll();
    }
}
