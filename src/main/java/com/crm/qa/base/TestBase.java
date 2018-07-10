package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		
		try {
			prop=new Properties();
			FileInputStream fis;
			fis = new FileInputStream("D:\\Java\\CRMTest\\src\\main\\java\\com\\crm\\qa\\config\\Config.properties");
			
				prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public static void initialization() {
			String browsername=prop.getProperty("browser");
			if(browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
				
				//log.info("Creating object of "+browser);
				driver=new ChromeDriver();
			}
			else if(browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/driver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
			else if(browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_Wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
		
	



	

}
