import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ttttt {
  public static void main(String[]args) {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://pinewz.com");
	  System.out.println(driver.getTitle());
	  System.out.println(driver.getCurrentUrl());
	  
  }


}
//WebDriver driver = new ChromeDriver();
//driver.get("https://dev-aisug-ui.project-turbine.in/#/login");