package WikipediaTesting;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestWikipedia {
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver=new FirefoxDriver();
//		System.setProperty("webdriver.ie.driver","C:\\Users\\rgrac\\OneDrive\\Documents\\Applications\\IEDriverServer.exe");
//		WebDriver driver=new InternetExplorerDriver();
//		WebDriver driver=new ChromeDriver();
		driver.get("http://www.wikipedia.org/");
		WebElement link=driver.findElement(By.linkText("English"));
		link.click();
		Thread.sleep(5000);
		WebElement searchBox;
		searchBox= driver.findElement(By.id("searchInput"));
		searchBox.sendKeys("software");
		searchBox.submit();
		searchBox= driver.findElement(By.id("searchInput"));
	
		driver.quit();
	}
}
