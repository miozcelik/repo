package selenium_class.TESTNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.*;

public class Annotations {

    @Test(priority = 1, enabled= false)
    public void test1(){
        System.out.println("Test Annotation 1");

    }

    @Test( alwaysRun=true)
    public void test2(){
        System.out.println("Test Annotation 2");

    }

    @Test(dependsOnMethods = "test4")
    public void test3(){
        System.out.println("Test Annotation 3");

    }

    @Test()
    public void test4(){
        System.out.println("Test Annotation 4");
        Assert.assertTrue(false);

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method Annotation");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method Annotation");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class Annotation");

    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class Annotation");
    }

    @BeforeTest
    public void beforeTest(){
        //It will run before everything which we mentioned until now and only one time
        System.out.println("Before Test Annotation");

    }

    @AfterTest
    public void afterTest(){
        //it will run after everything which we mentioned until now and only one time.
        System.out.println("After Test Annotation");

    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite Annotation");

    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite Annotation");
    }

    @BeforeSuite
    public void beforeSuite1(){
        System.out.println("Before Suite Annotation");
    }


}
