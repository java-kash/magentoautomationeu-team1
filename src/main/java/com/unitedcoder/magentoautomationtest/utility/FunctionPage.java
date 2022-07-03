package com.unitedcoder.magentoautomationtest.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

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



    public  String generateMiddleName(){
        Faker faker=new Faker();
        String  middleName=faker.name().username();
        return middleName;
    }






}
