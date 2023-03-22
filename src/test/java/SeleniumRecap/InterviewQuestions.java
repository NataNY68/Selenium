package SeleniumRecap;

public class InterviewQuestions {
    /*;
    1 - What are the advantages and disadvantages of Selenium

        ADVANTAGES:
           1. It supports multiple languages and browser
           2. It has a big community
           3. Free resource
        DISADVANTAGES:
           1. You cannot automate captcha, pictures, mobile applications, etc
           2. There is no direct call(customer service) for support
           3. It only automates Web Applications (browser)
           4. It does not have any system to generate report, so we use external resources (testng, cucumber,...)


    2 - What type of testing can you automate with Selenium?

         1. Regression
         2. Smoke
         3. Functional test(positive and negative)


    3 - What are the test types you do not automate with Selenium?

         1. Performance Testing (Jmeter --> it is not really hard to learn)
         2. Manual Testing (captcha, pictures)
         3. Non-Functional Testing (stress testing, loading testing, performance,... )
         4. Adhoc Testing (randomly testing)


    4 - What is locator in Selenium? What type of locators do you use in your framework?

         Locator is a way to find the element/s from DOM (DEVELOPMENT TOOL/ PAGE)
           The locators that I am using in my framework are:
             1. ID - finds the element with ID Attribute
             2. Name - find the element with Name Attribute
             3. ClassName - find the element with ClassName attribute
             4. TagName - find the element with TagName
             5. LinkText - find the element with 'a' tagName and 'text'
             6. PartialLinkText - find the element with 'a' tagName and 'partialText' or fullText
             7. CSS - find the element with CSS (id or class) - for id(#), for class(.)
             8. Xpath - find the element with xpath.


   5 - How do you handle dynamic elements in UI Automation?

         In my project, I`ve faced many dynamic elements during UI Automation:
           To handle this issue I did:
             1. I used parent-child relationship for the elements
             2. I used different ways to locate the elements (like following-sibling,
                 preceding sibling, contains, etc ...)
             3. I found the element with different attribute which is not dynamic.


   6 - Difference between driver.get() and driver.navigate() ?

        Navigate(): - it does not wait webElement to be loaded from page (It waits for
                     only specific elements that you are looking from page)
                    - it has methods:
                       navigate.to(), navigate.refresh(), navigate.back(),
                       navigate.forward().

        Get(): - it waits all the webElements from page to be loaded
               - it does not have any methods


   7 - Difference between driver.close() and driver.quit() ?

        Driver.close() - it specifically closes the window that your driver is pointing.
                         * it closes only one tab

        Driver.quit() - it closes all the tabs that were opened during the automation run.


   8 - What is xpath and can you tell me about types of xpath? Which one do you use the most?
   8.1 - What is the difference between Absolute and Relative xpath?

        Xpath - is one of the locators that I use in Selenium to find the element.
           There are 2 types of xpath:
             1. Absolute xpath:
                  - It goes from all the way top (html) to child.
                  - It starts with single slash (/).

             2. Relative xpath:
                  - It goes directly to the child or parent/child
                       example: //div[@id='parent']//a[.='child']  -- parent-child
                       example: //div[@id='parent']//following-sibling::a  -- following-sibling
                  - It starts with double slash(//)

        NOTE: I use definitely the relative xpath the most since it is more functional
              and effective to locate the elements.


    9 - How do handle drop-downs? (Static or dynamic drop-downs)
         In my project, I was handling the drop-downs with different ways:

           First:  I would definitely check the tag of the webElement (location)
                     - If the location has 'Select' tagName then I use Select Class
                        example: Select select = new Select(locationOfElement)
                     - If the location does not have 'Select' tagNme then I use:
                          - Action class methods like click or WebElements method click
                            and choose option
                          - I would use sendKeys() to choose the option.


   10 - Can you tell me what do you know about Select Class and it`s methods?

         Select class is a way to handle Drop-Downs:
           - it is really useful for my project
           - the WebElement must have Select tagName;

         Select select = new Select(locationOfElement)
           1. select.selectByVisibleText("textValue");
           2. select.selectByValue("value");
           3. select.selectByIndex(indexNumber);
           4. select.getFirstSelectedOption() -- it will give you default option selected
           5. select.getOptions() -- it will give you all options (return List<String>)


   11 - What kind of exceptions have you faced in your automation Framework?

         1. NoSuchElement Exception
         2. StaleElementReference Exception
         3. ElementIntercepted Exception
         4. ElementIsNotInteractable Exception
         5. NoSuchWindow Exception
         6. NoSuchFrame Exception
         7. TestNG Exception
         8. UnhandledAlert Exception
         9. TimeOut Exception
         10. InvalidSelector Exception

   12 - How do you handle Stale Element Reference Exception?

         In my project, this exception is one of the hard ones that was giving me headache:

           This exception happens when:
             - the dom is not updated fast
             - the dom`s element value is changed
             - the page is refreshed

           Wait times might solve the issue:
             - I would use Thread.sleep or Explicitly wait with condition
         **  - I would reassign and reinitialize the webElement
             - I would refresh the page.


   13 - How do you handle pop-ups? Can you tell me the methods that you handle JS alert?

         There are different types of pop-ups that I have faced during automation?

          1. Operation System (OS): We cannot handle it directly with Selenium
          2. HTML alert/Pop-ups: I just need to find the element and click on it
             (like OK or CANCEL button)
          3. JavaScript alert/pop-up: I handle it with Alert Interface
             Alert alert = driver.switchTo().alert();

             - alert.accept() -- it clicks 'OK' button from alert
             - alert.dismiss() -- it clicks 'CANCEL' button from alert
             - alert.getText() -- it gets the text from alert
             - alert.sendKeys() -- it sends the key to the alert.


   14 - What do you know about iframe? And how do you handle this in your automation?

         - Iframe is html inside html.
         - It is used for protection purposes
         - It is widely used for Ads, documents or videos

       First, switch your frame based on the value of WebElement:
          - driver.switchTo.frame(id or name)
          - driver.switchTo.frame(WebElement)
          - driver.switchTo.frame(index)
          - driver.switchTo.ParentFrame() -- it will go to the parent frame
          - driver.switchTo.defaultContent() -- it will no matter what go to the main html directly
                                                no matter what, how many times you switch your frame
                                                from parent to child with this method, it will directly
                                                skip all the parents and go to the main html

       NOTE: If you do not handle this iframe, you will get NoSuchElement Exception
       NOTE: If the value of switchFrame is wrong, you will get NoSuchElement Exception


  15 - What do you know about Actions class and can you tell me the methods you used tho most during
       automation?

         Actions class basically does the functionality of mouse. I can say it is really useful in
         some cases during the Automation to handle some elements.

         Some important methods are:

    IQ *** - ContextClick - it right click on the webElement    *IQ - interview question
           - DoubleClick - it double clicks the element
           - DragAndDrop - it drags and drops the element from one spot to another spot
           - ClickAndHold - it clicks and holds the element
     *     - MoveToElement - it hovers over the element
           - release - it releases the element that you are holding (it mostly comes after ClickAndHold)
           - click() - it clicks the element
           - sendKeys() - it sends the key
  *****    - perform() - it performs the actions method (Without that, it will not work)


  16 - What is the difference between driver.findElement and driver.findElements?

        FindElement:  1. driver.findElement(By.locator("")); - Syntax
                      2. Returns single WebElement
                      3. Once it fails, it throws NoSuchElement Exception

        FindElements: 1. driver.findElements(By.locator("")); - Syntax
                      2. Returns List<WebElement>
                      3. Once it fails, it returns nothing (empty List)


  17 - Can you tell me some driver and WebElement methods you use during the Automation mostly?

        Driver methods: - get(),
                        - navigate(),
                        - getTitle(),
                        - getCurrentUrl(),
                        - switchTo(),
                        - quit(),
                        - close(),
                        - GetWindowHandle/s
                        - manage()

         WebElement methods: - click(),
                             - sendKeys(),
                             - getText(),
                             - isDisplayed(),
                             - isSelected(),
                             - getAttribute(),
                             - getCSSValue(),
                             - clear(),
                             - submit.


   18 - What is the difference between check-box and radio button?

        CheckBox -- you can click multiple boxes

        RadioButton -- you can choose only one


   19 - How do you handle multiple windows in Automation? And what is the difference between
        getWindowHandle() and getWindowHandled()?

         To be able to handle the windows:

            I need to switch my driver into the specific window with my logic

              Set<String> allWindowsID = driver.getWindowHandles();

              for(String pageID: allWindowsID){
                driver.switchTo.window(pageID);
                  if(driver.getTitle.contains("expectedTitle")){
                    break;
                    }
              }

          1. Use getWindowHandles to store all pages ID
          2. Loop through all pages and switch
          3. Break the loop when title is what I am looking for

       NOTE: GetWindowHandle() -- return String with single page ID
             GetWindowHandles() -- return Set<String> with all pages IDs


  20 - How do you scroll down-up in WebBrowsers during the Automation?

    ***** I mostly use JS scrollIntoView script (I store it in my Browser Utils for any time usage)

           - actions.scrollByAmount(x,y)
           - Keys.PageUp or Down
           - Keys.ArrowUp or Down


  21 - How do you upload file in Selenium?

        1. First of all, you need to find the location of choose button
        2. Find the path of the file that you are going to attach (//C://Users//usa.png)
        3. Then Send the keys of location to the choose Button.


  22 - What is the difference between Assert and SoftAssert?

        Assert - is a class that have some methods to validate actual and expected data.
           Assert.assertEquals, assertTrue/False
           *When it fails, it throws exception right away and do not execute the next line of the code.

        SoftAssert: It is a class that have some methods to validate actual and expected data.
          * We need to create an Object:
               SofAssert softAssert = new SoftAssert();
          * When it fails, it does not throw an exception, it keeps executing the next lines of the code.
          *You must use Assert.all() to make it work properly. Otherwise, it will pass all the time.


  23 - Can you tell me about your Singleton Pattern design? Can you make the Constructor private, static, final?

        First of all, I appreciate for this question since I like singleton logic because
        in the past, I was working on my driver and getting lots of NullPointOf Exception.
        With the help of Singleton, I centralize my driver which reduces the amount of
        exception I got which means it is more reliable and safe to use.

           I basically Encapsulate my Singleton:

             - I need to have Private WebDriver
             - I need to have private constructor
             - Put if condition to check my driver is null or not
             - Create a public method to call it from other classes/

  24 - What kind of TestNG annotation do you use in you Project? Can you tell me what is
       the purpose of @Parameter usage?

  25 - What do you know about @DataProvider and why do you use it?

  26 - What do you know about Wait Times nad can you tell me the difference between Thread.sleep(),
       Implicitly, Explicitly, FluentlyWait?


     */
}
