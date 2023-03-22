package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){//it will run before everything, it will clear the cookies and caches
        System.out.println("I am before Suite annotation");
    }

    @BeforeTest
           public void beforeTest(){
        System.out.println("I am before Test annotation");
    }

    @BeforeClass // it runs before every clas and people use to lunch their browser driver =DriverHelper.getDriver()
    public void beforeClass(){
        System.out.println("I am before class annotation");
    }

    @BeforeMethod // it runs before every test annotation and it is good to use for setting up your automation
    //TESTBASE CLASS
    public void beforeMethod(){
        System.out.println("I am before method annotation");
    }

    @Test //it execute the codes
    public void test(){
        System.out.println("I am @Test Annotation");
    }

    @Test
    public void test1(){
        System.out.println("I am second test Annotation");
    }

    @AfterMethod // It runs after every test annotation, and it is good to use for screenshot and quit your driver
    public void afterMethod(){
        System.out.println("I am after method annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after test annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after Suite Annotation");
    }
}
