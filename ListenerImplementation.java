package Commonutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  implements ITestListener{
	
	ExtentReports report;

	

		
		
	public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
		//System.out.println("Testscript execution is started");
			String methodName = result.getMethod().getMethodName();
			Reporter.log(methodName+"Testscript excution is started",true);
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			//System.out.println("Testscript execution is Passed");
			String methodName = result.getMethod().getMethodName();
			Reporter.log(methodName+"Testscript excution is Passed",true);
		
		
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			//System.out.println("Testscript execution is failed");	
			String message = result.getThrowable().toString();
			String methodName = result.getMethod().getMethodName();
			Reporter.log(methodName+"Testscript excution is failed"+message,true);
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			//System.out.println("Testscript excution is skippe");
			String methodName = result.getMethod().getMethodName();
			Reporter.log(methodName+"Testscript excution is skipped",true);
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			//System.out.println("To start the execution");
			//Reporter.log("To start the execution",true);
			
			Javautils jutil=new Javautils();
			//use extent spark reporter class just configure extent  
			ExtentSparkReporter reporter=new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
			reporter.config().setDocumentTitle("vtigercrm");
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setReportName("Mogli");
			
			//use Extentreports to generate extentreport 
			report=new ExtentReports();
			report.attachReporter(reporter);
			report.setSystemInfo("OS", "Window");
			report.setSystemInfo("Chromeversion", "121");
			report.setSystemInfo("Author", "Mogli");
			
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			//System.out.println("To finish the execution");
			//Reporter.log("To finish the execution",true);
			
			report.flush();
		}

		

		}
