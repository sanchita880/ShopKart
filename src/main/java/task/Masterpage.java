package task;
import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.I1;
public class Masterpage implements I1 {
	WebDriver driver;
	boolean status;
    @BeforeTest
   
	void Load_Url() 
	{
		driver = new ChromeDriver();
		driver.get(base_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
    @Test
    void check_status() {
    status = driver.getPageSource().contains("About");
	System.out.println("status");
	if(status==true) 
	{
		
		driver.findElement(id_signin).click();
	    }
    }
    @Test
    void  Log_in() 
    {
    	loginpage obj = new loginpage(driver);
    }
  
}


