package WikipediaTesting;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestIndeed {
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver=new FirefoxDriver();
//		System.setProperty("webdriver.ie.driver","C:\\Users\\rgrac\\OneDrive\\Documents\\Applications\\IEDriverServer.exe");
//		WebDriver driver=new InternetExplorerDriver();
//		WebDriver driver=new ChromeDriver();
		driver.get("http://www.indeed.com/");
		Thread.sleep(5000);

		WebElement link1,link2,search_value;
//
//		driver.findElement(By.id("what")).sendKeys("Selenium");
//		link2=driver.findElement(By.id("where"));
//		link2.clear();
//		link2.sendKeys("virginia");
//		driver.findElement(By.id("fj")).click();
//		search_value = driver.findElement(By.id("searchCount"));
//		System.out.println(search_value.getText());
//		Thread.sleep(5000);
		driver.quit();
	}
}
