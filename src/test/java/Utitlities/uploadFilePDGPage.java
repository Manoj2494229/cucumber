package Utitlities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class uploadFilePDGPage  extends Help {


	public  void uploadFile(WebDriver driver , String imgLocationxpath , String imgUrl ,String Fromxpath , String Toxpath) throws Exception
	
	{
		WebElement webElement = driver.findElement(By.xpath(imgLocationxpath));
		String script = "arguments[0].innerHTML='<img src=\""+imgUrl+"\" width=\"200\" height=\"200\">'";
		System.out.println(script);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript(script, webElement);
		//Element which needs to drag.    		
		WebElement Drag=driver.findElement(By.xpath(Fromxpath));	
		Thread.sleep(1000);
		//Element on which need to drop.		
		WebElement Drop=driver.findElement(By.xpath(Toxpath));					
		Thread.sleep(1000);
		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);					
		Thread.sleep(1000);
		//Dragged and dropped.		
		act.dragAndDrop(Drag, Drop).build().perform();
	}

}
