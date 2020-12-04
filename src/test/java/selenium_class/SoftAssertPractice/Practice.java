package selenium_class.SoftAssertPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practice {

    @Test
    public void test1(){

        Assert.assertEquals(3,5);
        System.out.println("Hard Assert test");
    }

    @Test
    public void test2(){

        Assert.assertEquals(5,5);
        System.out.println("After assert 1 ");
        Assert.assertEquals(3,5);
        System.out.println("After assert 2 ");
        Assert.assertEquals(6,5);
        System.out.println("After assert 3 ");
    }

    @Test
    public void test3(){
        SoftAssert soft=new SoftAssert();

        soft.assertEquals(5,5);
        System.out.println("After soft assert 1");
        soft.assertEquals("Google","Home-Google");
        System.out.println("After soft assert 2");
        soft.assertEquals(6,6);
        System.out.println("After soft assert 3");

        //until assertAll, all assertion will be executed on this page.
        //When you do more than one assertion inside your one test case, It will be better to use soft assertion
        soft.assertAll();
        System.out.println("Test Assert All");

    }

}
