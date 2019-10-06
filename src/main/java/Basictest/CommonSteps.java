package Basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utility.Util;

public class CommonSteps extends BasicTest {

	public static boolean enterValue(String propvalue) throws InterruptedException {
		boolean status=false;
		String UserType = prop.getProperty("UserType");
		String value = Util.readExcel(propvalue, UserType);
		String name= prop.getProperty(propvalue);
		String[] valueName= name.split("\\{");
		String cvalue =valueName[1];
		//System.out.println(valueName[0] + valueName[1]);
		Thread.sleep(1000);
		WebElement field;
		switch(cvalue) {
		
		case "xpath":
			System.out.println("finding the enement with xpath");
			 field = driver.findElement(By.xpath(valueName[0]));
			field.sendKeys(value);
			status=true;
			break;
		case "name":
			System.out.println("finding the enement with xpath");
			field = driver.findElement(By.name(valueName[0]));
			field.sendKeys(value);
			status=true;
			break;
		case "cssselector":
			System.out.println("finding the enement with xpath");
			field = driver.findElement(By.cssSelector(valueName[0]));
			field.sendKeys(value);
			status=true;
			break;
		case "class":
			System.out.println("finding the enement with xpath");
			field = driver.findElement(By.className(valueName[0]));
			field.sendKeys(value);
			status=true;
			break;
		case "id":
			System.out.println("finding the enement with xpath");
			field = driver.findElement(By.id(valueName[0]));
			field.sendKeys(value);
			status=true;
			break;
		}
		return status;
		}
	

//submit method
	
public static boolean commonClick(String propvalue) throws InterruptedException {
	boolean status=false;
	String name= prop.getProperty(propvalue);
	String[] valueName= name.split("\\{");
	String cvalue =valueName[1];
	//System.out.println(valueName[0] + valueName[1]);
	Thread.sleep(1000);
	WebElement field;
	switch(cvalue) {
	
	case "xpath":
		System.out.println("finding the enement with xpath");
		 field = driver.findElement(By.xpath(valueName[0]));
		 field.click();
		 status=true;
		break;
	case "name":
		System.out.println("finding the enement with xpath");
		field = driver.findElement(By.name(valueName[0]));
		field.click();
		status=true;
		break;
	case "cssselector":
		System.out.println("finding the enement with xpath");
		field = driver.findElement(By.cssSelector(valueName[0]));
		field.click();
		status=true;
		break;
	case "class":
		System.out.println("finding the enement with xpath");
		field = driver.findElement(By.className(valueName[0]));
		field.click();
		status=true;
		break;
	case "id":
		System.out.println("finding the enement with xpath");
		field = driver.findElement(By.id(valueName[0]));
		field.click();
		status=true;
		break;
	}
	return status;
	}
}

	


