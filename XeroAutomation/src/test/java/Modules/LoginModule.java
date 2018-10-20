package Modules;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestScripts.XeroApplication;


public class LoginModule extends XeroApplication{
	public WebDriver login(WebDriver driver) throws Exception {
	String curDir=System.getProperty("user.dir");
	Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
	Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
      
	//String expectedErrorText="Please check";	
		   
		    


		
		
		WebElement userName=driver.findElement(getLocator("Xero.LoginPage.Username", objpro));
		enterText(userName, objpro.getProperty("Xero.LoginPage.ValidUsername"), "UserName");
		
		WebElement password=driver.findElement(getLocator("Xero.LoginPage.Password",objpro));					
		enterText(password, objpro.getProperty("Xero.LoginPage.ValidPassword"), "Password");

		WebElement loginBtn=driver.findElement(getLocator("Xero.LoginPage.SubmitBtn", objpro));
		clickObj(loginBtn, "LoginBtn");

		System.out.println(driver.getTitle());
	    checkGetTitle(objpro.getProperty("Xero.HomePage.HomepageTitle"), "The User Home Page");		    
	
		return driver;
					}
}

