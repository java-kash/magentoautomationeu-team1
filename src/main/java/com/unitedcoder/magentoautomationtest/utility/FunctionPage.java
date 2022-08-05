package com.unitedcoder.magentoautomationtest.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public  class FunctionPage {
    WebDriver driver;
    static  String  configFile="config-qa.properties";
    public static int timeout=Integer.parseInt(TestBase.readFromConfigProperties(configFile,"timeout"));
    Faker faker=new Faker();

    public FunctionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    public  void fluentWait(WebElement element){
        Wait<WebDriver> wait=new FluentWait<>(driver)
   //     Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(20,TimeUnit.SECONDS)
                .pollingEvery(100,TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String generateFirstName(){
        String firstName=faker.name().firstName();
        return firstName;
    }
    public String generateLastName(){
        String lastName=faker.name().lastName();
        return lastName;
    }
    public String generateEmail(){
        String email=faker.internet().emailAddress();
        return email;
    }
    public String generateCityName(){
        String cityName=faker.address().city();
        return cityName;
    }

    public String generateStreetName(){
        String streetName=faker.address().streetName();
        return streetName;
    }


    public String generateZipCode(){
        String zipCode=faker.address().zipCode();
        return zipCode;
    }

    public String  generateTelephoneNumber(){
        String telephoneNumber=faker.phoneNumber().cellPhone();
        return telephoneNumber;
    }


    public  String generateMiddleName(){
        Faker faker=new Faker();
        String  middleName=faker.name().username();
        return middleName;
    }


    public void waitForAlertPresent(){
        WebDriverWait wai=new WebDriverWait(driver,timeout);
        wai.until(ExpectedConditions.alertIsPresent());
    }

//alertAccept
    public void alertAccept(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageName(String pageName) {
        WebElement name = driver.findElement(By.xpath("//*[contains(text(),'" + pageName + "')]"));
        return name.getText();
    }

    public void hoverToClick(String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='" + text + "']"))).click().perform();
    }

    public  List<String> getElementsText(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elements) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public  int getSectionCount(By locator) {
        return driver.findElements(locator).size();
    }

    /**
     * This method for selecting randomly
     */
    public  void randomSelect(String locator) {
        Random random = new Random();
        List<WebElement> listInSections = driver.findElements(By.xpath(locator));
        int list = random.nextInt(listInSections.size());
        listInSections.get(list).click();
    }

    /**
     * Click on Button with visible span text
     */
    public  void clickOnButton(String buttonName) {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//div[@class='wrapper']//*[@type='button']//*[contains(text(),'" + buttonName + "')]"))).perform();
    }

    //get h3 text
    public String getPageNameH3(String pageName) {
        WebElement name = driver.findElement(By.xpath("//h3[text()='" + pageName + "']"));
        return name.getText();
    }

    public boolean getSuccessMessage(String message){
        return driver.getPageSource().contains(message);
    }

    public  void clickAnywhere(int xCoordinate, int yCoordinate) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
        actions.moveByOffset(xCoordinate, yCoordinate).click().build().perform();
    }


    public void clearField(WebElement webElement) {

        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        webElement.clear();

    }


    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     *
     * @param targetTitle
     */
    public void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /*
    index 0 -> main window
    index 1 -> child window
     */
    public void switchToNextTab(int index) {
        String windowId = null;
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> iter = windowIds.iterator();
        for (int i = 0; i <= index; i++) {
            windowId = iter.next();
        }
        driver.switchTo().window(windowId);
    }

    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public  void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public  void sendKeysWithJS(WebElement element, String text) {
//        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + text + "';", element);
    }

    public void scrollToElementWithElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void pageDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public  void pageUp() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public  void scrollToPoint(int x, int y) {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(" + x + ", " + y + ");");
    }

    public void scrollToElement(WebElement element) {
        Point p = element.getLocation();
        int X = p.getX();
        int Y = p.getY();
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(" + X + ", " + Y + ");");
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(1000,0)");
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Highlighs an element by changing its background and border color
     *
     * @param element
     */
    public void highlight(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        sleep(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    //Draw boarder around the element
    public void drawBoarder(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    //Get title with JS
    public String getTitleByJS() {
        return ((JavascriptExecutor) driver).executeScript("return document.title;").toString();
    }

    //refresh the page
    public void refreshBrowser() {
        ((JavascriptExecutor) driver).executeScript("history.go(0)");
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    /**
     * attempts to click on provided element until given time runs out
     *
     * @param element
     * @param timeout
     */
    public void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                sleep(1);
            }
        }
    }


}
