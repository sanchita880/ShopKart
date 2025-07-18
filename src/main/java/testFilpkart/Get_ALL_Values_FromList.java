package testFilpkart;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.I1;

//import org.openqa.selenium.WebDriver;

public class Get_ALL_Values_FromList implements I1 {
	WebDriver driver;

	
    @BeforeTest
	void open_webpage() 
	{
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
    @Test
    void Search_product() 
    {
    //	driver.findElement(Search_Xpath).sendKeys("Mobile");
    	WebElement we = driver.findElement(Search_Xpath);
    	we.sendKeys("Mobile");
    	we.sendKeys(Keys.ENTER);
    	List<WebElement> List_of_webelement = driver.findElements(List_Xpath);
    	//driver.findElements(List_Xpath);
    	int length = List_of_webelement.size();
    	System.out.println(length);
    
    
    if (length !=0) 
    {
    	for(WebElement input_List_of_webelement :List_of_webelement) 
    	{
    		String mob_list = input_List_of_webelement.getText();
    		System.out.println(mob_list);
    		//need this data:Motorola Edge 50 Fusion (Marshmallow Blue, 256 GB)
    		boolean Status=input_List_of_webelement.getText().contains("Motorola Edge 50 Fusion (Marshmallow Blue, 256 GB)");
    		System.out.println("Status="+Status);
    		if (Status==true) 
    		{
    			input_List_of_webelement.click();	
    		}
    		else 
    		{
    			System.out.println("Status Does not match");
    		}
    	}
    	
    	
    }
    else 
    {
    	System.out.println("length is equal to zero");
    }
      }
        }
