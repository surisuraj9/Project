package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginnPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		TestBase.initialization();
		loginnPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validatePageTittleTest(){
		Assert.assertEquals(loginnPage.validatePageTittle(),"CRMPRO - CRM software for customer "
				+ "relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void validateCRMImageTest(){
		TestBase.driver.switchTo().parentFrame();
		Assert.assertTrue(loginnPage.validateCRMImage());
	}

	@Test(priority=3)
	public void loginTest(){
		TestBase.driver.switchTo().parentFrame();
		homePage=loginnPage.login(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown(){
		TestBase.driver.quit();
	}
	
}
