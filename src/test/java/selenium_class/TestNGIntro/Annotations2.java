package selenium_class.TestNGIntro;

import org.testng.annotations.Test;

public class Annotations2 {

    @Test(invocationCount = 10, priority = 0)
    public void test1(){

        System.out.println("Test 1 execution");
    }

    @Test(invocationCount = 10, priority = -1) // it will be executed first since -1 lower than 0
    public void test2(){

        System.out.println("Test 2 execution");
    }

    @Test(expectedExceptions = {ArithmeticException.class, RuntimeException.class})
    public void test3(){

        System.out.println("Test 3 execution");
        throw new NullPointerException();
    }



}

