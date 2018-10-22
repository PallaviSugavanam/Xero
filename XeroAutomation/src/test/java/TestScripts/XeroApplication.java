package TestScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Modules.LoginModule;
import Modules.MyXeroModule;

public class XeroApplication extends XeroReusableMethods{

@Test
	
		public static void Navigate_to_XERO() throws Exception  {
	
	 
	 
		String curDir=System.getProperty("user.dir");
		Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
		Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
        CreateReport("Navigate_to_XERO");			;         
		//String expectedErrorText="Please check";	
	    launchBrowser("firefox");			   
			    
		launchApplication(pro.getProperty("XeroUrl"), "Xero ");
		checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");

		 LoginModule l=new LoginModule();
			l.login(driver);
			/*WebElement userName=driver.findElement(getLocator("Xero.LoginPage.Username", objpro));
			enterText(userName, objpro.getProperty("Xero.LoginPage.ValidUsername"), "UserName");
			
			WebElement password=driver.findElement(getLocator("Xero.LoginPage.Password",objpro));					
			enterText(password, objpro.getProperty("Xero.LoginPage.ValidPassword"), "Password");

			WebElement loginBtn=driver.findElement(getLocator("Xero.LoginPage.SubmitBtn", objpro));
			clickObj(loginBtn, "LoginBtn");

			System.out.println(driver.getTitle());
		    checkGetTitle(objpro.getProperty("Xero.HomePage.HomepageTitle"), "The User Home Page");	
		    */
		    
			closeDriver();
						}

@Test
	
		public static void Incorrect_Password() throws Exception  {
	
	 
		String curDir=System.getProperty("user.dir");
		Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
		Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
        CreateReport("Incorrect_Password");			;         
		//String expectedErrorText="Please check";	
	    launchBrowser("firefox");			   
			    
		launchApplication(pro.getProperty("XeroUrl"), "Xero ");
		checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");

			
			
			WebElement userName=driver.findElement(getLocator("Xero.LoginPage.Username", objpro));
			enterText(userName, objpro.getProperty("Xero.LoginPage.ValidUsername"), "UserName");
			
			WebElement password=driver.findElement(getLocator("Xero.LoginPage.Password",objpro));					
			enterText(password, objpro.getProperty("Xero.LoginPage.InValidPassword"), "Invalid Password");

			WebElement loginBtn=driver.findElement(getLocator("Xero.LoginPage.SubmitBtn", objpro));
			clickObj(loginBtn, "LoginBtn");
			
			WebElement errorMsg=driver.findElement(getLocator("Xero.LoginPage.ErrorMsg", objpro));
			verifyText(errorMsg, "The Error Msg ", objpro.getProperty("Xero.LoginPage.ExpectedErrorMsgForInvaliPassword"));

			closeDriver();
						}




@Test
	
		public static void Incorrect_Email() throws Exception  {
	
	 
		String curDir=System.getProperty("user.dir");
		Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
		Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
        CreateReport("Incorrect_Email");			;         
		//String expectedErrorText="Please check";	
	    launchBrowser("firefox");			   
			    
		launchApplication(pro.getProperty("XeroUrl"), "Xero ");
		checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");			
			
			WebElement userName=driver.findElement(getLocator("Xero.LoginPage.Username", objpro));
			enterText(userName, objpro.getProperty("Xero.LoginPage.InValidUsername"), "InValidUserName");
			
			WebElement password=driver.findElement(getLocator("Xero.LoginPage.Password",objpro));					
			enterText(password, objpro.getProperty("Xero.LoginPage.ValidPassword"), "Valid Password");

			WebElement loginBtn=driver.findElement(getLocator("Xero.LoginPage.SubmitBtn", objpro));
			clickObj(loginBtn, "LoginBtn");
			
			WebElement errorMsg=driver.findElement(getLocator("Xero.LoginPage.ErrorMsg", objpro));
			logger.log(Status.INFO,  "The Expected text is "+objpro.getProperty("Xero.LoginPage.ExpectedErrorMsgForInvaliPassword"));	
			verifyText(errorMsg, "The Error Msg ", objpro.getProperty("Xero.LoginPage.ExpectedErrorMsgForInvaliPassword"));

			closeDriver();
						}

@Test

public static void Navigate_to_XERO1() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("Navigate_to_XERO1");			;         
//String expectedErrorText="Please check";	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroUrl"), "Xero ");
checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");	

WebElement forgotPassword=driver.findElement(getLocator("Xero.LoginPage.ForgotPassword",objpro));
clickObj(forgotPassword, "The Forgot Password ");

checkGetTitle(objpro.getProperty("Xero.ForgotPage.Title"), "The Forgot Page");	

WebElement userName=driver.findElement(getLocator("Xero.ForgotPage.email", objpro));
enterText(userName, objpro.getProperty("Xero.LoginPage.ValidUsername"), "ValidUserName");
Thread.sleep(2000);
WebElement sendLink=driver.findElement(getLocator("Xero.ForgotPage.Submit",objpro));
clickObj(sendLink, "The Send Link ");
Thread.sleep(2000);
WebElement errorMsg5=driver.findElement(getLocator("Xero.ForgotPage.DisplayedText1", objpro));
logger.log(Status.INFO,  "The Expected text is "+objpro.getProperty("Xero.ForgetPage.ExpDisplayText"));	
verifyText(errorMsg5, "The Error Msg ", objpro.getProperty("Xero.ForgetPage.ExpDisplayText"));
closeDriver();
				}



@Test

public static void SignUp_To_XDC_A() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("SignUp_To_XDC_A");			;         
//String expectedErrorText="Please check";	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroFreeTrialUrl"), "Xero Free Trial  ");
//checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");	
WebElement freeTrial=driver.findElement(getLocator("Xero.FreeTrial",objpro));
clickObj(freeTrial, "The Free Trial ");
Thread.sleep(2000);
System.out.println(driver.getTitle());
checkGetTitle(objpro.getProperty("Xero.FreeTrial.Title"), "The SignUp Page");	
System.out.println(objpro.getProperty("Xero.FreeTrial.Title"));

WebElement firstName=driver.findElement(getLocator("Xero.FreeTrial.FirstName", objpro));
enterText(firstName, objpro.getProperty("Xero.FreeTrial.ValidFirstName"), "ValidFirstName");


WebElement LastName=driver.findElement(getLocator("Xero.FreeTrial.LastName", objpro));
enterText(LastName, objpro.getProperty("Xero.FreeTrial.ValidLastName"), "ValidLasttName");

WebElement email=driver.findElement(getLocator("Xero.FreeTrial.Email", objpro));
enterText(email, objpro.getProperty("Xero.FreeTrial.ValidEmail"), "ValidEmailName");

WebElement Phone=driver.findElement(getLocator("Xero.FreeTrial.PhoneNumber", objpro));
enterText(Phone, objpro.getProperty("Xero.FreeTrial.ValidPhoneNumber"), "ValidPhoneName");


WebElement Country=driver.findElement(getLocator("Xero.FreeTrial.Country", objpro));
SelectDropdown(Country, "text", "United States", "United States");

WebElement CheckBtn=driver.findElement(getLocator("Xero.FreeTrial.CheckBtn",objpro));
clickObj(CheckBtn, "The Check Button ");
WebElement GetStarted=driver.findElement(getLocator("Xero.FreeTrial.GetStarted",objpro));
clickObj(GetStarted, "The Get Started Button ");

closeDriver();
		}

@Test

public static void SignUp_To_XDC_B() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("SignUp_To_XDC_B");			;         
//String expectedErrorText="Please check";	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroFreeTrialUrl"), "Xero Free Trial  ");
//checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");	
WebElement freeTrial=driver.findElement(getLocator("Xero.FreeTrial",objpro));
clickObj(freeTrial, "The Free Trial ");
Thread.sleep(2000);
System.out.println(driver.getTitle());
//checkGetTitle(objpro.getProperty("Xero.FreeTrial.Title"), "The SignUp Page");	
//System.out.println(objpro.getProperty("Xero.FreeTrial.Title"));
/*
WebElement firstName=driver.findElement(getLocator("Xero.FreeTrial.FirstName", objpro));
enterText(firstName, objpro.getProperty("Xero.FreeTrial.ValidFirstName"), "ValidFirstName");


WebElement LastName=driver.findElement(getLocator("Xero.FreeTrial.LastName", objpro));
enterText(LastName, objpro.getProperty("Xero.FreeTrial.ValidLastName"), "ValidLasttName");

WebElement email=driver.findElement(getLocator("Xero.FreeTrial.Email", objpro));
enterText(email, objpro.getProperty("Xero.FreeTrial.ValidEmail"), "ValidEmailName");

WebElement Phone=driver.findElement(getLocator("Xero.FreeTrial.PhoneNumber", objpro));
enterText(Phone, objpro.getProperty("Xero.FreeTrial.ValidPhoneNumber"), "ValidPhoneName");


WebElement Country=driver.findElement(getLocator("Xero.FreeTrial.Country", objpro));
SelectDropdown(Country, "text", "United States", "United States");

WebElement CheckBtn=driver.findElement(getLocator("Xero.FreeTrial.CheckBtn",objpro));
clickObj(CheckBtn, "The Check Button ");
*/
WebElement GetStarted=driver.findElement(getLocator("Xero.FreeTrial.GetStarted",objpro));
clickObj(GetStarted, "The Get Started Button ");

WebElement FirstNameerrorMsg=driver.findElement(getLocator("Xero.FreeTrial.FirstNameErrMsg", objpro));
logger.log(Status.INFO,  "The Expected text is "+objpro.getProperty("Xero.FreeTrial.ExpFirstNameErrMsg"));	
verifyText(FirstNameerrorMsg, "The Error Msg ", objpro.getProperty("Xero.FreeTrial.ExpFirstNameErrMsg"));

WebElement LastNameerrorMsg=driver.findElement(getLocator("Xero.FreeTrial.LastNameErrMsg", objpro));
logger.log(Status.INFO,  "The Expected text is "+objpro.getProperty("Xero.FreeTrial.ExpLastNameErrMsg"));	
verifyText(LastNameerrorMsg, "The Error Msg ", objpro.getProperty("Xero.FreeTrial.ExpLastNameErrMsg"));

WebElement EmailerrorMsg=driver.findElement(getLocator("Xero.FreeTrial.EmailErrMsg", objpro));
logger.log(Status.INFO,  "The Expected text is "+objpro.getProperty("Xero.FreeTrial.ExpEmailErrMsg"));	
verifyText(EmailerrorMsg, "The Error Msg ", objpro.getProperty("Xero.FreeTrial.ExpEmailErrMsg"));

WebElement PhoneerrorMsg=driver.findElement(getLocator("Xero.FreeTrial.PhoneErrMsg", objpro));
logger.log(Status.INFO,  "The Expected text is "+objpro.getProperty("Xero.FreeTrial.ExpPhoneErrMsg"));	
verifyText(PhoneerrorMsg, "The Error Msg ", objpro.getProperty("Xero.FreeTrial.ExpPhoneErrMsg"));

WebElement email=driver.findElement(getLocator("Xero.FreeTrial.Email", objpro));
enterText(email, objpro.getProperty("Xero.FreeTrial.WrongFormatEmail"), "The Wrong Format Email");

//WebElement EmailerrorMsg=driver.findElement(getLocator("Xero.FreeTrial.EmailErrMsg", objpro));
logger.log(Status.INFO,  "The Expected text is "+objpro.getProperty("Xero.FreeTrial.ExpWrongFormatEmailErrMsg"));	
verifyText(EmailerrorMsg, "The Error Msg ", objpro.getProperty("Xero.FreeTrial.ExpWrongFormatEmailErrMsg"));

closeDriver();
		}


@Test

public static void SignUp_To_XDC_C() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("SignUp_To_XDC_C");			;         
//String expectedErrorText="Please check";	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroFreeTrialUrl"), "Xero Free Trial  ");
//checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");	
WebElement freeTrial=driver.findElement(getLocator("Xero.FreeTrial",objpro));
clickObj(freeTrial, "The Free Trial ");
Thread.sleep(2000);
System.out.println(driver.getTitle());
WebElement termsOfUse=driver.findElement(getLocator("Xero.FreeTrial.termsOfUse",objpro));
clickObj(termsOfUse, "The Terms  Button ");

windowHandling("parentWindow", "Terms", "Terms of Use");

WebElement privacy=driver.findElement(getLocator("Xero.FreeTrial.Privacy",objpro));
clickObj(privacy, "The Privacy  Button ");

windowHandling("parentWindow", "Privacy", "Privacy Notice");
closeDriver();

}

@Test

public static void SignUp_To_XDC_D() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("SignUp_To_XDC_D");			;         
//String expectedErrorText="Please check";	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroFreeTrialUrl"), "Xero Free Trial  ");
//checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");	
WebElement freeTrial=driver.findElement(getLocator("Xero.FreeTrial",objpro));
clickObj(freeTrial, "The Free Trial ");
Thread.sleep(2000);
System.out.println(driver.getTitle());
WebElement offerDetail=driver.findElement(getLocator("Xero.FreeTrial.OfferDetail",objpro));
clickObj(offerDetail, "The Offer Detail ");

windowHandling("parentWindow", "OfferDetail", "Offer details");

closeDriver();

}

@Test

public static void SignUp_To_XDC_E() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("SignUp_To_XDC_E");			;         
//String expectedErrorText="Please check";	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroFreeTrialUrl"), "Xero Free Trial  ");
//checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");	
WebElement freeTrial=driver.findElement(getLocator("Xero.FreeTrial",objpro));
clickObj(freeTrial, "The Free Trial ");
Thread.sleep(2000);
System.out.println(driver.getTitle());
WebElement accountant=driver.findElement(getLocator("Xero.FreeTrial.accountant",objpro));
clickObj(accountant, "The Accountant ");

windowHandling("parentWindow", "Accountant", "Accountant");

closeDriver();

}

@Test
	
		public static void Test_All_Tabs() throws Exception  {
	
	 
	 
		String curDir=System.getProperty("user.dir");
		Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
		Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
        CreateReport("Test_All_Tabs");			;         
		//String expectedErrorText="Please check";	
	    launchBrowser("firefox");			   
			    
		launchApplication(pro.getProperty("XeroUrl"), "Xero ");
		checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");

		 LoginModule l=new LoginModule();
			l.login(driver);
		
			WebElement dashboard=driver.findElement(getLocator("Xero.HomePage.Dashboard",objpro));
			clickObj(dashboard, "The DashBoard ");
	        checkGetTitle("Dash Board", "Dashboard");
	        
	    	WebElement accounts=driver.findElement(getLocator("Xero.HomePage.Accounts",objpro));
			clickObj(accounts, "The Accounts ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Account Page Dropdown is opened", ExtentColor.GREEN));
			
		/*	WebElement payroll=driver.findElement(getLocator("Xero.HomePage.Payroll",objpro));
			clickObj(payroll, "The Payroll ");
			/*logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Payroll Page Dropdown is opened", ExtentColor.GREEN));
			WebElement payrollDisplay=driver.findElement(getLocator("Xero.HomePage.Payroll.Display",objpro));
			if(payrollDisplay.isDisplayed()) {
				logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Payroll Page Dropdown is opened", ExtentColor.GREEN));				
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel("Pass:The Payroll Page Dropdown is  not opened", ExtentColor.GREEN));				

			}*/
	
			WebElement Projects=driver.findElement(getLocator("Xero.HomePage.Projects",objpro));
			clickObj(Projects, "The Projects ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Projects Page Dropdown is opened", ExtentColor.GREEN));
			
			WebElement Reports=driver.findElement(getLocator("Xero.HomePage.Reports",objpro));
			clickObj(Reports, "The Reports ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Reports Page Dropdown is opened", ExtentColor.GREEN));
			Thread.sleep(2000);
			WebElement Contacts=driver.findElement(getLocator("Xero.HomePage.Contacts",objpro));
			clickObj(Contacts, "The Contacts ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Contacts Page Dropdown is opened", ExtentColor.GREEN));
			
			WebElement Settings=driver.findElement(getLocator("Xero.HomePage.Settings",objpro));
			clickObj(Settings, "The Settings ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Settings Page Dropdown is opened", ExtentColor.GREEN));
			
			WebElement QuickLaunch=driver.findElement(getLocator("Xero.HomePage.QuickLaunch",objpro));
			clickObj(QuickLaunch, "The QuickLaunch ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The QuickLaunch Page Dropdown is opened", ExtentColor.GREEN));
			
			WebElement Files=driver.findElement(getLocator("Xero.HomePage.Files",objpro));
			clickObj(Files, "The Files ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Files Page Dropdown is opened", ExtentColor.GREEN));
			
			WebElement Notifications=driver.findElement(getLocator("Xero.HomePage.Notifications",objpro));
			clickObj(Notifications, "The Notifications ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Notifications Page Dropdown is opened", ExtentColor.GREEN));
			
			WebElement Search=driver.findElement(getLocator("Xero.HomePage.Search",objpro));
			clickObj(Search, "The Search ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Search Page Dropdown is opened", ExtentColor.GREEN));
			
			WebElement Help=driver.findElement(getLocator("Xero.HomePage.Help",objpro));
			clickObj(Help, "The Help ");
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Help Page Dropdown is opened", ExtentColor.GREEN));
			
			
			
			closeDriver();
						}

@Test

public static void Test_Logout_Functionality() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("Test_Logout_Functionality");			;         
	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroUrl"), "Xero ");
checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");

 LoginModule l=new LoginModule();
	l.login(driver);

	WebElement userDropDown=driver.findElement(getLocator("Xero.HomePage.Userdropdown",objpro));
	List<WebElement> list=driver.findElements(getLocator("Xero.HomePage.ListOfUserdropdown", objpro));
	dropdown(userDropDown, list, "Logout");
	
	checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");
	WebElement userName=driver.findElement(getLocator("Xero.LoginPage.Username", objpro));
	
	verifyAttribute(userName, "value", "The UserNmae", objpro.getProperty("Xero.LoginPage.ValidUsername"));

	closeDriver();	

}
@Test
public static void Upload_Profile_Window() throws Exception  {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("Upload_Profile_Window");			;         
	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroUrl"), "Xero ");
checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");



	WebElement userDropDown=driver.findElement(getLocator("Xero.HomePage.Userdropdown",objpro));
	List<WebElement> list=driver.findElements(getLocator("Xero.HomePage.ListOfUserdropdown", objpro));
	dropdown(userDropDown, list, "Profile");
	System.out.println(driver.getTitle());
	checkGetTitle(objpro.getProperty("Xero.Profile.ProfileTitle"), "The Profile ");
	WebElement uploadPhoto=driver.findElement(getLocator("Xero.Profile.UploadPhoto", objpro));
	clickObj(uploadPhoto, "The Upload Photo ");
	
	WebElement browse=driver.findElement(getLocator("Xero.Profile.BrowseImage", objpro));
	enterText(browse,"G:\\Kaushik_8th_BDay\\Phone\\IMG_20160214_190005.jpg", "Upload" );
	

	closeDriver();	

}
@Test
public static void Add_another_organization_Trail_version_1() throws Exception {

String curDir=System.getProperty("user.dir");
Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
CreateReport("Add_another_organization_Trail_version_1");			;         
	
launchBrowser("firefox");			   
	    
launchApplication(pro.getProperty("XeroUrl"), "Xero ");
Thread.sleep(2000);
System.out.println(driver.getTitle());

Thread.sleep(2000);

MyXeroModule l=new MyXeroModule();
l.MyXero(driver);

WebElement startTrial=driver.findElement(getLocator("Xero.Organisation.StartTrial", objpro));
clickObj(startTrial, "Start Trial");

closeDriver();
}
@Test
public static void Add_another_organization_StandardVersion() throws Exception {
	String curDir=System.getProperty("user.dir");
	Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
	Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
    CreateReport("Add_another_organization_StandardVersion");			;         
	//String expectedErrorText="Please check";	
    launchBrowser("firefox");			   
		    
	launchApplication(pro.getProperty("XeroUrl"), "Xero ");
	checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");

MyXeroModule l=new MyXeroModule();
l.MyXero(driver);


WebElement BuyNow=driver.findElement(getLocator("Xero.Organisation.BuyNow", objpro));
clickObj(BuyNow, "Buy Now ");
System.out.println(driver.getTitle());
WebElement Starter=driver.findElement(getLocator("Xero.Organisation.Starter", objpro));
clickObj(Starter, "Starter  ");

WebElement Continue=driver.findElement(getLocator("Xero.Organisation.Continue", objpro));
clickObj(Continue, "Continue  ");

WebElement Street=driver.findElement(getLocator("Xero.Organisation.Street", objpro));
enterText(Street, objpro.getProperty("Xero.Organisation.StreetText"), "Street");

WebElement Town=driver.findElement(getLocator("Xero.Organisation.Town", objpro));
enterText(Town, objpro.getProperty("Xero.Organisation.TownText"), "Town");

WebElement State=driver.findElement(getLocator("Xero.Organisation.State", objpro));
clickObj(State, "State  ");

WebElement California=driver.findElement(getLocator("Xero.Organisation.California", objpro));
clickObj(California, "California  ");
WebElement Zipcode=driver.findElement(getLocator("Xero.Organisation.ZipCode", objpro));
enterText(Zipcode, objpro.getProperty("Xero.Organisation.Zipcode"), "Zipcode");

WebElement Continue1=driver.findElement(getLocator("Xero.Organisation.Continue1", objpro));
clickObj(Continue1, "Continue  ");
WebElement VerifyAddress=driver.findElement(getLocator("Xero.Organisation.VerifyAddress", objpro));
verifyText(VerifyAddress, "Address", objpro.getProperty("Xero.Organisation.VerifyText"));



//7.Enter valid Billing contact street, valid city , valid state, valid zipcode
closeDriver();
}
@Test
public static void Add_another_organization_with_current_Quickbooks_user() throws Exception {
	String curDir=System.getProperty("user.dir");
	Properties pro=loadProperty(curDir+"./src/test/resources/Utility/config.Properties");
	Properties objpro=loadProperty(curDir+"./src/test/resources/Utility/XeroObjectRepository.properties");	
    CreateReport("Add_another_organization_with_current_Quickbooks_user");			;         
	//String expectedErrorText="Please check";	
    launchBrowser("firefox");			   
		    
	launchApplication(pro.getProperty("XeroUrl"), "Xero ");
	checkGetTitle(objpro.getProperty("Xero.LoginPage.LoginTitle"), "The Login ");
	

MyXeroModule l=new MyXeroModule();
l.MyXero(driver);

WebElement convert=driver.findElement(getLocator("Xero.Organisation.ConvertQuickbook", objpro));
clickObj(convert, "convert  ");
WebElement convert1=driver.findElement(getLocator("Xero.Organisation.ConvertQuickbook1", objpro));
clickObj(convert1, "convert  ");
WebElement StartTrail1=driver.findElement(getLocator("Xero.Organisation.QuickbookStartTrail", objpro));
if(!StartTrail1.isEnabled()) {
	logger.log(Status.PASS, MarkupHelper.createLabel("Start trail is not enabled", ExtentColor.GREEN));
}
else {
	logger.log(Status.FAIL,MarkupHelper.createLabel("Start Trail is enabled", ExtentColor.RED));
}

WebElement Continue2=driver.findElement(getLocator("Xero.Organisation.QuickbookContinue", objpro));
if(Continue2.isEnabled()) {
	logger.log(Status.PASS, MarkupHelper.createLabel("Continue is Enabled enabled", ExtentColor.GREEN));
}
else {
	logger.log(Status.FAIL,MarkupHelper.createLabel("Continue is not enabled", ExtentColor.RED));
}

clickObj(Continue2, "Continue");
WebElement FileConversion=driver.findElement(getLocator("Xero.Organisation.FileConversion", objpro));
verifyText(FileConversion, "FileConversion", "Quick books file conversion"	);
}


}
