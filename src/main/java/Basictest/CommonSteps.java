package Basictest;

import java.util.List;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Util;

public class CommonSteps extends BasicTest {
	static WebDriverWait wait = new WebDriverWait(driver,20);

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

public static void selectFromDropdown() {
	
	WebElement element = driver.findElement(By.id("id"));
	Select sel =new Select(element);
	List<WebElement> list=sel.getOptions();
	for(WebElement we: list) {
		String st=we.getText();
		if(st.equalsIgnoreCase("value")) {
			sel.selectByValue(st);
		}
		
	}
	
}

public static void doubleClick() {
	
	WebElement we= driver.findElement(By.id("ID"));
	Actions act = new Actions(driver);
	act.doubleClick(we).perform();
	
	Action mouseHover= act.moveToElement(we).build();
	mouseHover.perform();
	
	WebElement wes= driver.findElement(By.id("IDS"));
	WebElement wed= driver.findElement(By.id("IDD"));
	
	Action dragndrop= act.dragAndDrop(wes, wed).build();
	dragndrop.perform();
	
	
	driver.switchTo().alert().setCredentials((Credentials) new UsernamePasswordCredentials("cheese",
			    "secretGouda"));
	
	wait.until(ExpectedConditions.visibilityOf(we));
	
	
	
}

}

	


