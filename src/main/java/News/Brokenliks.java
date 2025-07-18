package News;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Brokenliks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
				
		WebDriver driver = new ChromeDriver();
		driver.get("https://prod-wion.project-turbine.in/");
 List<WebElement> links = driver.findElements(By.tagName("a")); // collecting all links list
 
 System.out.println("no of links"+links.size());
	XSSFWorkbook workbook=new XSSFWorkbook(); // create  sheet we created new workbook inside the workbook we created sheet
	XSSFSheet sheet=workbook.createSheet("broken link");
	  // Create the header row
	 XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("URL");
        header.createCell(1).setCellValue("Status");
        
        int rowNum = 1;  // Start from second row

        // Iterate through links
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url != null && !url.isEmpty()) {
                String status = checklink(url);

                // Write data to Excel
                XSSFRow row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(url);
                row.createCell(1).setCellValue(status);
            }
            
            
        }

        // Save the Excel file
        try (FileOutputStream fileOut = new FileOutputStream("BrokenLinks.xlsx")) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Excel file saved: BrokenLinks.xlsx");
        } catch (IOException e) {
        	 e.printStackTrace();
        }
        }
        	 
            
	public static String checklink (String linkurl)//created method
	{
		try { 
			URL url = new URL(linkurl);
			HttpURLConnection httpurlConnection= (HttpURLConnection) url.openConnection();
			httpurlConnection.setConnectTimeout(5000);
			httpurlConnection.connect();
			
			if(httpurlConnection.getResponseCode()>=400)// if we are getting 400 it means its broken link
				{
				System.out.println(linkurl +"---->"+httpurlConnection.getResponseMessage()+" is a broken link");
				}
			else
			{
				System.out.println(linkurl +"---->"+httpurlConnection.getResponseMessage());
			}
			
			
		}
		catch (Exception e) {
            System.out.println("Error checking link: " + linkurl + " -> " + e.getMessage());
            return "Error - " + e.getMessage();
            }
		return linkurl;
		}
}
