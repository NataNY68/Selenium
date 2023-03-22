package TestNG;

import org.testng.annotations.Test;

public class TestNG_Intro {

    @Test (priority = 2)// test annotation --> let us create more than one main method
    public void test1(){
        System.out.println("I am test1");
    }

    @Test(priority = 1, invocationCount = 5)
    public void test2(){
        System.out.println("I am test2");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("I am test3");
    }


}
