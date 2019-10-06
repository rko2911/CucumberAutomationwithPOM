package Basictest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Utility.Log;
import Utility.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest{

	public static WebDriver driver;
	public static Properties prop;
	
	
	//Constructor of basic test clads 
	
	public BasicTest() {
		prop=new Properties();
		Log.info("Setup property file nd read data from it");
		try {
			FileReader fi = new FileReader("src\\main\\java\\Configuration\\Config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			System.out.println("exception : properties find not fount " + e);
			e.printStackTrace();
		}catch (IOException e1) {
			System.out.println("exception : properties find not fount " + e1);
			e1.printStackTrace();
		}
	}
	
	
	public static boolean initialize(String url) {
		String browser;
		boolean status;
		browser=prop.getProperty("browser");
		System.out.println("the given browser is : " + browser);
		if(browser.equalsIgnoreCase("chrome")) {
		System.out.println("Logger info : launching the chrome browser");
		System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty(url));
		driver.manage().window().maximize();
		status= true;
	}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Logger info : launching the FF browser");
			System.setProperty("webdriver.gecko.driver","C:\\Users\\rkojh_000\\git\\CucumberAutomationwithPOM\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty(url));
			status = true;
		}
		else {
			status= false;
		}
		return status;
	}
	//Different methods	
	
}
