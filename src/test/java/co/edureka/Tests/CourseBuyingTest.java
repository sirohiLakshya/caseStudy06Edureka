package co.edureka.Tests;

import co.edureka.PageObjects.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.stream.FileCacheImageInputStream;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CourseBuyingTest {
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    SearchForCoursePage searchForCoursePage;
    CourseListPage courseListPage;
    CourseInfoPage courseInfoPage;
    CoursePaymentPage coursePaymentPage;
    String expectedPageTitle;

    @Test
    public void buyingCourse() throws AWTException, InterruptedException, IOException {
        driver = new ChromeDriver();
        FileInputStream file = new FileInputStream("\\Utils\\KeyWords.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();

        for(int row=1;row<=rows;row++){
            XSSFRow rowData = sheet.getRow(row);
            String currAction = rowData.getCell(1).toString().toLowerCase();
            if(currAction.equals("login")){
                logInPage = new LogInPage(driver);
                homePage = logInPage.logInValidUser("lakshya.22ks@gmail.com","Test@1234");
            }else if(currAction.equals("courseSearch".toLowerCase())){
                searchForCoursePage = homePage.searchCourse();
                courseListPage = searchForCoursePage.searchForCourse("Selenium");
            }else if(currAction.equals("openCoursePage".toLowerCase())){
                courseInfoPage = courseListPage.SelectCourse();
            }else if(currAction.equals("enrollInCourse".toLowerCase())){
                coursePaymentPage = courseInfoPage.enrollInCourse();
            }else if(currAction.equals("payment".toLowerCase())){
                expectedPageTitle = coursePaymentPage.proccedToPayment();
            }else if(currAction.equals("testValidation".toLowerCase())){
                String actualPageTitle = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
                Assert.assertEquals(actualPageTitle,expectedPageTitle);
            }
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
