package News;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class withexcle {

    public static void main(String[] args) {
        // Set the correct path to ChromeDriver (update the path as per your system)
      // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanchita.Halder\\eclipse-workspace\\Project\\BrokenLinks.xlsx");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wionews.com/"); 
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
        header.createCell(2).setCellValue("responseCode");

        int rowNum = 1; // Start writing data from the second row

        // Iterate through links and check responses
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url != null && !url.isEmpty() && url.startsWith("http"))
            {
            	int responseCode = getResponseCode(url);
                String status1 = responseCode >= 400 ? "Broken" : "Valid";
                String status = checkLink(url); // Check link status
                
                
                //  Write data to Excel
                XSSFRow row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(url);
                row.createCell(1).setCellValue(status);
                row.createCell(1).setCellValue(responseCode);
            }
        }

        //  Save Excel File
        try (FileOutputStream fileOut = new FileOutputStream("BrokenLinks.xlsx")) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println(" Excel file saved: BrokenLinks.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit(); // Close browser
    }

    private static int getResponseCode(String url) {
		// TODO Auto-generated method stub
		return 0;
	}

	//  Method to check link response
    public static String checkLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.connect();

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            if (responseCode >= 400) {
                System.out.printf("%s --> %s (Broken Link)  Response Code: %d%n", linkUrl, responseMessage, responseCode);
                System.out.printf("%s --> %s (Response Code: %d)%n", linkUrl, responseMessage, responseCode);

            } else {
                System.out.printf("%s --> %s (Working Link)  Response Code: %d%n", linkUrl, responseMessage, responseCode);
            }
            
        } catch (Exception e) {
            System.out.println("Error checking link: " + linkUrl + " -> " + e.getMessage());
            return "Error - " + e.getMessage();
        }
		return linkUrl;
    }
}
