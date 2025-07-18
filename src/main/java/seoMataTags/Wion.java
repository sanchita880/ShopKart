package seoMataTags;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.I1;

public class Wion  implements I1{
	WebDriver driver;
	boolean status;
    @BeforeTest
   
	void Load_Url() 
	{
		driver = new ChromeDriver();
		driver.get(wion_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    @Test
    void Meta_tags() 
    {
    	List<WebElement> metaTags = driver.findElements(By.xpath("//meta"));
    	 for (WebElement metaTag : metaTags) {
             String name = metaTag.getAttribute("name"); 
             String content = metaTag.getAttribute("content"); 
             System.out.println("Meta Name: " + name);
             System.out.println("Meta Content: " + content);
    	 }

    }
}
