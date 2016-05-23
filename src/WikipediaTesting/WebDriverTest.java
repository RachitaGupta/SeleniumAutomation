package WikipediaTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverTest {

	public static void main(String args[]) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgrac\\Desktop\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://cbis.snapinc.net/");
//		Thread.sleep(1000);
//		WebElement link=driver.findElement(By.name("name"));
//		link.sendKeys("name inc");
//		WebElement link2=driver.findElement(By.name("email"));
//		link2.sendKeys("email@inc.net");
//		WebElement link3=driver.findElement(By.name("dropdown"));
//		link3.sendKeys("dropdown2");
//		WebElement link4=driver.findElement(By.name("textarea"));
//		link4.sendKeys("textarea inc");
//		WebElement link5=driver.findElement(By.name("button"));
		
		Thread.sleep(3000);
//		link5.click();
		driver.close();
	}
}
