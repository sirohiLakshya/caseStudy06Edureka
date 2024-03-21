package co.edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    WebDriver driver;
    By buttonForLoginPopUp = By.xpath("/html/body/header/nav/ul/li[4]/span");
    By emailIdBox  = By.xpath("//*[@id=\"si_popup_email\"]");
    By passwordBox = By.xpath("//*[@id=\"si_popup_passwd\"]");
    By logInButton = By.xpath("//*[@id=\"new_sign_up_optim\"]/div/div/div[2]/div[3]/form/button");
    By edurekaLogo = By.xpath("/html/body/header/nav/div[2]/a/img");

    public LogInPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://www.edureka.co/");
        if(!driver.getTitle().equals("Instructor-Led Online Training with 24X7 Lifetime Support | Edureka")){
            throw new IllegalStateException("This is not login page, current url: "+driver.getCurrentUrl());
        }
    }

    public HomePage logInValidUser(String userEmailId, String password){
        driver.findElement(buttonForLoginPopUp).click();
        driver.findElement(emailIdBox).sendKeys(userEmailId);
        driver.findElement(passwordBox).sendKeys(password);
        driver.findElement(logInButton).click();
        try{
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        }

        return new HomePage(driver);
    }
}
