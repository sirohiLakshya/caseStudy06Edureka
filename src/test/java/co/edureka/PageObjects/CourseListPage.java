package co.edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CourseListPage {
    WebDriver driver;
    By courseCard = By.xpath("//*[@id=\"add-master-courses\"]/a[1]/div[1]");
    public CourseListPage(WebDriver driver, String courseName){
        this.driver=driver;
    }
    public CourseInfoPage SelectCourse(){
        driver.findElement(courseCard).click();
        return new CourseInfoPage(driver);
    }
}
