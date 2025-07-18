package PageObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class withexc{
public static void main(String[] args) {

	  WebDriver driver = new ChromeDriver();
      driver.get("https://www.wionews.com/photos"); 
      
      // Find all links on the page
      List<WebElement> links = driver.findElements(By.tagName("a"));
      System.out.println("Total links found: " + links.size());

      // Create Excel Workbook & Sheet
      XSSFWorkbook workbook = new XSSFWorkbook();
      XSSFSheet sheet = workbook.createSheet("Broken Links");

      // Create Header Row
      XSSFRow header = sheet.createRow(0);
      header.createCell(0).setCellValue("URL");
      header.createCell(1).setCellValue("Status");
      header.createCell(2).setCellValue("Response Code");

      int rowNum = 1; // Start writing data from the second row

      // Iterate through links and check responses
      for (WebElement link : links) {
          String url = link.getAttribute("href");

          if (url != null && !url.isEmpty() && url.startsWith("http")) {
              int responseCode = getResponseCode(url);
              String status = responseCode >= 400 ? "Broken" : "Valid";

              // Write data to Excel
              XSSFRow row = sheet.createRow(rowNum++);
              row.createCell(0).setCellValue(url);
              row.createCell(1).setCellValue(status);       // Status is in column 1
              row.createCell(2).setCellValue(responseCode); //Response code is in column 2
          }
      }

      // Save Excel File
      try (FileOutputStream fileOut = new FileOutputStream("BrokenLinks.xlsx")) {
          workbook.write(fileOut);
          workbook.close();
          System.out.println("Excel file saved: BrokenLinks.xlsx");
      } catch (IOException e) {
          e.printStackTrace();
      }

      driver.quit(); // Close browser
  }

  // Corrected Method to Get Response Code
  private static int getResponseCode(String linkUrl) {
      try {
          URL url = new URL(linkUrl);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setConnectTimeout(5000); // 5 seconds timeout
          connection.connect();

          int responseCode = connection.getResponseCode();
          String responseMessage = connection.getResponseMessage();

          System.out.printf("%s --> %s (Response Code: %d)%n", linkUrl, responseMessage, responseCode);
          return responseCode;
      } catch (Exception e) {
          System.out.println("Error checking link: " + linkUrl + " -> " + e.getMessage());
          return -1; // Return -1 for errors
      }
  }
}
