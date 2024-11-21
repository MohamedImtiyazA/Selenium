package com.Sample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/login/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links:"+allLinks.size());
		
		int brokenLinks = 0;
		int validLinks = 0;
		
	
		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");
			
			try {
				URL u = new URL("url");
				
				HttpURLConnection httpCon = (HttpURLConnection) u.openConnection();
				int rc = httpCon.getResponseCode();
				
				if (rc==20) {
					System.out.println("ValidLink:" + url);
					validLinks++;
				}
				else {
					System.out.println("BrokenLink:"+ url);
					brokenLinks++;
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Valid Link count:"+ validLinks);
		System.out.println("Broken Links Count:"+ brokenLinks);
		
		

	}

}
