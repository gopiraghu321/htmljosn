package Scenarios;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

public class Scenarios {
	

	
	public static void main(String[] args) {
		
		try {
			
			File htmlTemplateFile = new File("C:\\Apps2\\FusionExport.html");
			File JSONFile = new File("C:\\Apps2\\json.txt");
			String htmlString = FileUtils.readFileToString(htmlTemplateFile);			
			String jsonString = FileUtils.readFileToString(JSONFile);
			htmlString  = htmlString.replace("var chartConfig", " var chartConfig = "+jsonString);
			
			File newHtmlFile = new File("C:\\Apps2\\NewFusionExport.html");
			FileUtils.writeStringToFile(newHtmlFile, htmlString);
			System.setProperty("webdriver.chrome.driver", 
					"C://Apps//drivers//chromedriver.exe");

			WebDriver driver=new ChromeDriver();
			driver.get("C:\\Apps2\\NewFusionExport.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
