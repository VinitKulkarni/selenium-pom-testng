package tests;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentManager;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import static org.testng.Assert.assertEquals;

import java.io.File;

public class LoginTest extends BaseTest {

    static ExtentReports report;
    static ExtentTest test;

    @Test
    public void loginTest() {

        new File("reports").mkdirs();

        report = ExtentManager.getReport();
        test = report.createTest("SauceDemo Login Test");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        test.pass("Login successful");
    }
    
    @Test
    public void loginTest2() {
    	new File("reports").mkdirs();

        report = ExtentManager.getReport();
        test = report.createTest("SauceDemo Login Test2");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        test.pass("Login successful2");
    	
    }

    @AfterClass
    public void tearDownReport() {
        report.flush();
    }
}