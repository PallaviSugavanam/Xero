package Modules;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TestScripts.XeroApplication;

public class MyXeroModule extends XeroApplication {
	public WebDriver MyXero(WebDriver driver) throws Exception{
	String curDir=System.getProperty("user.dir");
	Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
	Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
	//CreateReport("Add_another_organization_Trail_version_1");			;         
	

WebElement userName=driver.findElement(getLocator("Xero.LoginPage.Username", objpro));
enterText(userName, objpro.getProperty("Xero.LoginPage.AdditionalValidUsername"), "UserName");

WebElement password=driver.findElement(getLocator("Xero.LoginPage.Password",objpro));					
enterText(password, objpro.getProperty("Xero.LoginPage.AdditionalValidPassword"), "Password");
verifyAttribute(password, "type", "The encrypted password is ", "password");
WebElement loginBtn=driver.findElement(getLocator("Xero.LoginPage.SubmitBtn", objpro));
clickObj(loginBtn, "LoginBtn");

checkGetTitle("Dashboard", "The Dashboard Page");
WebElement organisation=driver.findElement(getLocator("Xero.DashBoard.OrgName", objpro));
clickObj(organisation, "Organisation ");

WebElement xero=driver.findElement(getLocator("Xero.DashBoard.XeroName", objpro));
clickObj(xero, "Xero Organisation ");

WebElement orgDetails=driver.findElement(getLocator("Xero.DashBoard.OrganisationDetails", objpro));
IsDisplayed(orgDetails);
WebElement addorg=driver.findElement(getLocator("Xero.DashBoard.AddOrganisation", objpro));
clickObj(addorg, "Add Organisation ");
Thread.sleep(2000);

WebElement nameOrg=driver.findElement(getLocator("Xero.Organisation.Name", objpro));
enterText(nameOrg, objpro.getProperty("Xero.Organisation.NameText"), "The Name");

Thread.sleep(2000);
WebElement countryOrg=driver.findElement(getLocator("Xero.Organisation.PayTaxes", objpro));

enterText(countryOrg, "United States", "US");
//enterTextKeys(countryOrg, Keys.ENTER, "country");

Thread.sleep(2000);

WebElement TimeZone=driver.findElement(getLocator("Xero.Organisation.TimeZone", objpro));
enterText(TimeZone, "Pacific Time ", "Pac");
//enterTextKeys(TimeZone, Keys.ARROW_DOWN, "PST");
//enterTextKeys(TimeZone, Keys.ENTER, "PST");
Thread.sleep(2000);

WebElement doOrg=driver.findElement(getLocator("Xero.Organisation.Do", objpro));
enterText(doOrg, objpro.getProperty("Xero.Organisation.DoText"), "The Do");
enterTextKeys(doOrg, Keys.ENTER, "Accounting");
Thread.sleep(2000);
	return driver;

}
}
