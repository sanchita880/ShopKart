package utility;

import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriverService;

public interface I1 {

	String base_url ="https://sach.org.in/";
	
	//locators
	By id_signin = By.xpath("//span[normalize-space()='Login']");
		
	String url ="https://www.flipkart.com/";
	By Search_Xpath = By.xpath("//input[@placeholder='Search for Products, Brands and More']");
	By List_Xpath = By.xpath("//div[ @class=\"KzDlHZ\"]");
	
	String wion_url ="https://www.wionews.com/";
	String India_url ="https://www.india.com/";
}
