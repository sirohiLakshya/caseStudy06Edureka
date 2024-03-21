package co.edureka.PageObjects;

import org.openqa.selenium.WebDriver;

import java.awt.*;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        if(!driver.getTitle().equals("Instructor-Led Online Training with 24X7 Lifetime Support | Edureka")) {
            throw new IllegalStateException("This is not homepage, current Url: " + driver.getCurrentUrl());
        }
    }

    public SearchForCoursePage searchCourse()
    {
        return new SearchForCoursePage(driver);
    }
}
