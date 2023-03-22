package WaitTimes;

public class ImplicitlyWait {

    /*
    We use it under DriverHelper, or @BeforeMethod

    driver.manage.timeouts(ImplicitlyWait(Duration.ofSeconds(10));

    It will throw NoSuchElementException, if it does not load in 10 sec
     */
}
