package co.edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class CoursePaymentPage {
    WebDriver driver;
    By paymentPopUpWindow = By.xpath("//*[@id=\"header-wrapper\"]");
    By proccedToPaymentButton = By.xpath("//*[@id=\"bth_select\"]/div/div/div[5]/button");
    By payButton = By.xpath("//*[@id=\"user_payment\"]/div/div/div[2]/div[1]/button");
    public CoursePaymentPage(WebDriver driver){
        this.driver=driver;
    }

    public String proccedToPayment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proccedToPaymentButton));
        driver.findElement(proccedToPaymentButton).click();
        driver.findElement(payButton).click();
        return driver.getTitle();
    }
}
