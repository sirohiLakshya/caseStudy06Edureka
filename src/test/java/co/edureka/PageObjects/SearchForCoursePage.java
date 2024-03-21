package co.edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class SearchForCoursePage {
    WebDriver driver;
    String courseName;
    By searchBar = By.xpath("//input[@aria-label='Enter Course, Category or keyword']\n");
    By searchQueryInputBox = By.xpath("//*[@id=\"search-input\"]");

    public SearchForCoursePage(WebDriver driver){
        this.driver = driver;
    }

    public CourseListPage searchForCourse(String courseName) throws AWTException, InterruptedException {
        this.courseName = courseName;
        driver.navigate().refresh();
        driver.findElement(searchBar).click();
        driver.findElement(searchQueryInputBox).sendKeys(courseName);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        return new CourseListPage(driver, courseName);
    }
}
