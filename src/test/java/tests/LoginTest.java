package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentManager;

public class LoginTest extends BaseTest{
	
	@Test
    public void loginTest() {

        ExtentReports report = ExtentManager.getReport();
        ExtentTest test = report.createTest("SauceDemo Login Test");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        test.pass("Login successful");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

        report.flush();
    }

}
