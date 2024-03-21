package co.edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CourseInfoPage {
    WebDriver driver;
    By enrollButton = By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[3]/div[3]/button[1]");
    public CourseInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public CoursePaymentPage enrollInCourse(){
        try{
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enrollButton));
        driver.findElement(enrollButton).click();

        return new CoursePaymentPage(driver);
    }
}
