package WikipediaTesting;
/***
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMParser {
	public static void main(String args[]) throws IOException, SAXException, InterruptedException{
		try {
			//config: url
			FileInputStream fis = new FileInputStream("config.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String url = null;
			url= br.readLine();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgrac\\Desktop\\Documents\\chromedriver.exe");
			String input=br.readLine();
			//input.txt: test cases
			File inputFile = new File(input);
			br.close();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("TestCase");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				WebDriver driver = new ChromeDriver();
				driver.get(url);

//				System.out.println("item name:"+ nNode.getNodeName());
				WebElement  link = null;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;	                  
					System.out.println("Student roll no : "+ eElement.getAttribute("rollno"));	                  
					for(int i=1;i<eElement.getChildNodes().getLength();i=i+2){

						String NodeName=eElement.getChildNodes().item(i).getNodeName();
						String TextContent= eElement.getChildNodes().item(i).getTextContent();
						System.out.println(TextContent);

						if(TextContent.equalsIgnoreCase("submit")||TextContent.equalsIgnoreCase("onclick")){
							link=driver.findElement(By.xpath("//*[@onclick or @submit or @button]"));
							link.click();
						}
						else if(NodeName.equals("radio")){
							link=driver.findElement(By.name(NodeName));

							String rvalue=link.getAttribute("value");
							if(rvalue.equalsIgnoreCase(TextContent)){
								link.clear();	
							}
						}
						else if(NodeName.equalsIgnoreCase("a")){
							if(driver.findElement(By.xpath("//*[@script or @link]"))!=null){
								continue;
							}
							List<WebElement> list=driver.findElements(By.xpath("//*[@href or @src]"));
							for(WebElement e : list){
								try{
									System.out.println("e: "+e.getText());
									String alink = e.getAttribute("src");
									if(null==alink)
										alink=e.getAttribute("href");
									//									System.out.println("alink: "+alink);
									if(alink.contains(".img")||alink.contains(".jpg")||alink.contains(".js")||alink.contains(".css")){
										continue;
									}

									e.click();
									driver.navigate().back();
								}
								catch(Exception e1){
									//System.out.println("e: "+e.getText());

									e1.printStackTrace();
								}
							}
						}
						else{
							link=driver.findElement(By.name(NodeName));
							link.sendKeys(TextContent);
						}
						System.out.println(NodeName);
					}
				}
				Thread.sleep(1000);
				driver.close();
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
