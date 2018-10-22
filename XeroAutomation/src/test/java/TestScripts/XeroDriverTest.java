package TestScripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;


public class XeroDriverTest extends XeroApplication {

@Test
	public static void mainmethod() throws  Exception {
	String curDir=System.getProperty("user.dir");
	String s_Path="F:/Pallavi/Selenium/gapInc/XeroAutomation/src/test/resources/Utility/XeroTestSuite.xls/";
	//String s_Path=curDir+"/src/test/resources/Utility/XeroTestSuite.xls";
	String testCase=null;
	String flag=null;
    executionReport("Sprint1");
	String[][] testSuiteData=readxlData(s_Path, "Sheet1");
	for (int i = 1; i < testSuiteData.length; i++) {
		flag=testSuiteData[i][1];
		if(flag.equalsIgnoreCase("Y")) {
			testCase=testSuiteData[i][0];
			   Method ts=XeroApplication.class.getMethod(testCase);
				ts.invoke(ts);
		}
			
				else {
					System.out.println("TestCase "+ testSuiteData[i][0]+"is not executed");
					
				}
		}
/*	testCase=testSuiteData[i][0];
	   Method ts=XeroApplication.class.getMethod(testCase);
		ts.invoke(ts);*/

		extent.flush();
	}

	}

