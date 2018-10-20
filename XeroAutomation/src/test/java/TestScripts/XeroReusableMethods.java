package TestScripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class XeroReusableMethods extends XeroBaseClass {
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent=null;
	//static ExtentTest logger=null;
	
	public static String[][] readxlData(String path,String sheetName) throws IOException{
		
		FileInputStream fs=new FileInputStream(new File(path));
		HSSFWorkbook workbook=new HSSFWorkbook(fs);
		HSSFSheet sheet=workbook.getSheet(sheetName);
		int rows=sheet.getLastRowNum()+1;
		int cols=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				//data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				HSSFCell cell=sheet.getRow(i).getCell(j);
				if(cell.getCellType()==CellType.STRING)
					data[i][j]=cell.getStringCellValue();
				else if(cell.getCellType()==CellType.NUMERIC)
					data[i][j]=String.valueOf(cell.getNumericCellValue());
			
			}
		}
		return data;
	}
	
	public static void launchApplication(String url,String urlName) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		logger.log(Status.PASS, MarkupHelper.createLabel(urlName +" Application is Launched", ExtentColor.GREEN));
	
	}
	
	public static void CreateReport(String testCaseName) {
		logger = extent.createTest(testCaseName);
		logger.log(Status.PASS, MarkupHelper.createLabel("TestReport for "+testCaseName, ExtentColor.BLUE));
		System.out.println("Test Case for "+testCaseName);
	}
	
	public static By getLocator(String strElement,Properties propertyFile) throws Exception {
        
        // retrieve the specified object from the object list
        String locator = propertyFile.getProperty(strElement);


         
        // extract the locator type and value from the object
        String locatorType = locator.split(":")[0];
        String locatorValue = locator.split(":")[1];
         
        // for testing and debugging purposes
        System.out.println("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the object map");
         
        // return a instance of the By class based on the type of the locator
        // this By can be used by the browser object in the actual test
        if(locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if(locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("Unknown locator type '" + locatorType + "'");
    }
	

public static Properties loadProperty(String Path) throws IOException {
Properties pro=new Properties();
BufferedReader reader = new BufferedReader(new FileReader(Path));
pro.load(reader);
return pro;
}
	/*
	 * Name of th Method:Execution Of Extent Report
	 * Brief Description:Click on Object
	 * Arguments:obj--->WebObj,textVal,ObjName
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	
	 public static void verifyText(WebElement element,String elementName,String expectedText ) throws IOException
		{
			if (element.isDisplayed())		
			{	
				logger.log(Status.INFO, "The  displayed Text is: "+element.getText());	
				if (element.getText().contains(expectedText))
					logger.log(Status.PASS, MarkupHelper.createLabel( elementName+" is displayed as expected", ExtentColor.GREEN));
				else{
					logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+"displayed is NOT as expected", ExtentColor.RED));
				String imagePath=takeScreenShot();
				logger.addScreenCaptureFromPath(imagePath);
				}
			}
			else
			{
				logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+" not found", ExtentColor.RED));
			}
		}
	 
	 

	 public static void verifyAttribute(WebElement element,String value,String elementName,String expectedText ) throws IOException
		{
			if (element.isDisplayed())
			{		logger.log(Status.INFO, "The  displayed Text is: "+element.getAttribute(value));	
				if (element.getAttribute(value).contains(expectedText))
					logger.log(Status.PASS, MarkupHelper.createLabel( elementName+" is displayed as expected", ExtentColor.GREEN));
				else{
					logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+"displayed is NOT as expected", ExtentColor.RED));
				String imagePath=takeScreenShot();
				logger.addScreenCaptureFromPath(imagePath);
				}
			}
			else
			{
				logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+" not found", ExtentColor.RED));
			}
		}

	public static String takeScreenShot() throws IOException{
		String reportPath=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String curDir=System.getProperty("user.dir");
		String destination=curDir+"/src/test/resources/ScreenShot/"+reportPath+"image.PNG";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destination),true);
		return destination;
	}
	public static void executionReport(String reportName) {
		String timeNow=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println(reportName+"_"+timeNow+".html");	
		String curDir=System.getProperty("user.dir");

		htmlReporter = new ExtentHtmlReporter(curDir+"/src/test/resources/ExtentReport/" + reportName+"_"+timeNow+".html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
	}
	
	
	/*
	 * Name of th Method:ClickObj
	 * Brief Description:Click on Object
	 * Arguments:obj--->WebObj,textVal,ObjName
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	
	
	public static void enterText(WebElement obj,String textVal,String objName) {
	if(obj.isDisplayed()) {
		obj.clear();
		obj.sendKeys(textVal);
		logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is Entered in " + objName +" Field", ExtentColor.GREEN));
	    }
		else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));
		}
		}
	
	


	/*
	 * Name of th Method:EnterTextKeys
	 * Brief Description:Enter Text with keys for AutoSuggestive
	 * Arguments:obj--->WebObj,textVal,ObjName
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	
	
	public static void enterTextKeys(WebElement obj,Keys textVal,String objName) {
	if(obj.isDisplayed()) {
		obj.clear();
		obj.sendKeys(textVal);
		logger.log(Status.PASS, MarkupHelper.createLabel("Selecting"+objName , ExtentColor.GREEN));
	    }
		else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));
		}
		}
	
	/*
	 * Name of th Method:ClickObj
	 * Brief Description:Click on Object
	 * Arguments:obj--->WebObj,textVal,ObjName
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	public static void clickObj(WebElement obj,String objName) {
	if(obj.isDisplayed()) {
		obj.click();
		logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is clicked", ExtentColor.GREEN));
		}
		else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));

		}
}
	
	
	/*
	 * Name of th Method:CheckRadio
	 * Brief Description:Click on Radio
	 * Arguments:obj--->WebObj,ObjName
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	public static void checkBoxObj(WebElement obj,String objName) {
	if(obj.isDisplayed()) {
		if(obj.isSelected()) {
			logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is already selected", ExtentColor.GREEN));

		}
		else {
		obj.click();
		logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is clicked", ExtentColor.GREEN));
		}
	}
	else {
		logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is not Displayed", ExtentColor.RED));
	}
	}
		

	/*
	 * Name of th Method:Dropdown
	 * Brief Description:Click on dropdown
	 * Arguments:obj--->WebObj,listobj,objname
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	public static void dropdown(WebElement obj,List<WebElement> listObj,String objName) {
		
	if(obj.isDisplayed()) {
	obj.click();


	for (int i = 0; i < listObj.size(); i++) {
		
		if(listObj.get(i).getText().contains(objName)) {
			listObj.get(i).click();	
			break;	
		}	
	}
	logger.log(Status.PASS, MarkupHelper.createLabel("Pass:"+objName +" is Succesfully Selected", ExtentColor.GREEN));

}
	else {
		logger.log(Status.FAIL, MarkupHelper.createLabel("Fail:"+objName +" +"
				+ "Cannot be Selected", ExtentColor.RED));

	}
	}
	/*
	 * Name of th Method:getTitle
	 * Brief Description:get thetitle displayed
	 * Arguments:obj--->webObj---.text
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	public static String getTitle() {

				logger.log(Status.INFO, MarkupHelper.createLabel("The title of the page is "+driver.getTitle(), ExtentColor.GREEN));	   
		
		        return driver.getTitle();
		
	
}


	/*
	 * Name of th Method:getText
	 * Brief Description:get the text displayed
	 * Arguments:obj--->webObj---.text
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	public static String getText(WebElement text,String value) {
		if(text.isDisplayed()) {
			logger.log(Status.INFO, "The "+value+" displayed is:");
			logger.log(Status.INFO,  text.getText());	
			System.out.println(text.getText());
		}else {
			logger.log(Status.INFO,"No message is Displayed");
		}
		return text.getText();
		
	
}
	/*
	 * Name of th Method:getAttribute
	 * Brief Description:Attribute value isdisplayed
	 * Arguments:obj--->webObj---.text
	 * CreatedBy:Automation Team
	 * Created Date:10/10/2018
	 * Last Modified Date:10/10/2018
	 */
	public static String getAttribute(WebElement text,String attValue,String value) {
		if(text.isDisplayed()) {
			
			logger.log(Status.INFO, "The "+value+" displayed is:");
			logger.log(Status.INFO,  text.getAttribute(attValue));
			System.out.println(text.getAttribute(attValue));
		}else {
			logger.log(Status.INFO,"No message is Displayed");
		}
		
		return text.getAttribute(attValue);
		
	
}
	

	
	public static void GetApplication(String url) {

		driver.get(url);
		logger.log(Status.PASS, MarkupHelper.createLabel("Pass:"+url +" is Launched Succesfully ", ExtentColor.GREEN));

	}
	
	public static void checkGetTitle(String gettitleName,String titleName) {
		
		System.out.println(driver.getTitle());
		logger.log(Status.INFO,"The displayed Title is "+driver.getTitle());
		if(driver.getTitle().contains(gettitleName)) {
			logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The "+titleName+"page is Opened Succesfully ", ExtentColor.GREEN));

		}
		else {
			logger.log(Status.FAIL, MarkupHelper.createLabel("Fail: The "+titleName+"Page is not Opened", ExtentColor.RED));

		}

	}
	public static void windowHandling(String parentWindow,String childWindow,String title) throws InterruptedException {		

	Thread.sleep(2000);
	ArrayList tabs1 = new ArrayList (driver.getWindowHandles());
	logger.log(Status.INFO,"The Number of tab opened are "+tabs1.size());
	System.out.println(tabs1.size());
	Thread.sleep(2000);
	logger.log(Status.INFO,"Switch to "+childWindow);
	driver.switchTo().window((String) tabs1.get(1)); 
	
	checkGetTitle(title, title);
	
	System.out.println(driver.getTitle());
	logger.log(Status.INFO,"Switch to "+parentWindow);

	driver.switchTo().window((String) tabs1.get(0));
	}
	
	
	public static void SelectDropdown(WebElement element,String methodType,String value2,String selItem) {		
	Select select=new Select(element);

	if(methodType.equals("value")) {
		select.selectByValue(value2);
	
	}
	else if(methodType.equals("text")){
		select.selectByVisibleText(value2);
	}
	else {
		Integer in=Integer.parseInt(value2);
		select.selectByIndex(in);
	}
	
	logger.log(Status.PASS, MarkupHelper.createLabel("Pass: "+selItem+" is Selected  Succesfully ", ExtentColor.GREEN));	
			
	
	}
	public static void checkGetText(WebElement text,String textName) {		
	System.out.println(text.getText());	
	if(text.getText().contains(textName)) {		
		
		
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Pass:The Test Case is Passed Succesfully ", ExtentColor.GREEN));
}
else {
	logger.log(Status.FAIL, MarkupHelper.createLabel("Fail: The Test case is Failed", ExtentColor.RED));

}
	
}
	
	
}





