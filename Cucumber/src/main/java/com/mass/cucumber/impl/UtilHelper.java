package com.mass.cucumber.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.UIFramework.compName.projName.helper.browserConfiguration.BrowserType;
import com.UIFramework.compName.projName.helper.browserConfiguration.ChromeBrowser;
import com.UIFramework.compName.projName.helper.resource.ResourceHelper;
import com.mass.cucumber.steps.Problem1Test;

/**
 * @author Rahul Kumar
 * 
 *
 */
public class UtilHelper {

	private final Logger log = UtilHelper.getLogger(Problem1Test.class);

	private static boolean root=false;
	private WebDriver driver;
	public UtilHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public static WebDriver getBrowserObject(BrowserType btype) throws Exception  {
		try {
			switch(btype) {
			case Chrome:
			System.setProperty("webdriver.chrome.driver",getResourcePath("Cucumber/configFile/chromedriver.exe"));
			WebDriver driver=		new ChromeDriver();
			return driver;
			case Firefox:
				System.setProperty("webdriver.gecho.driver",getResourcePath("Cucumber/configFile/gechodriver.exe"));
			 driver=		new ChromeDriver();
				return driver;	
			default: 
				throw new Exception("Driver not found"+ btype.name());
			}
			
		}catch(Exception e) {
			throw e;	
		}
	}
   /**
    * This method will make sure element is displayed
    * @param element
    * @return
    */
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is Displayed.." + element.getText());
			return true;
		} catch (Exception e) {
			log.error("element is not Displayed..", e.getCause());
			return false;
		}
	}
	
	/**
	 * This method will help to get the text of an element
	 * @param element
	 * @return
	 */
	public String getText(WebElement element){
		if(null == element){
			log.info("WebElement is null..");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			log.info("element text is .."+element.getText());
			return element.getText();
		}
		else{
			return null;
		}
	}
	
	/**
	 * This method will help us to get the Resoure Path
	 * @param path
	 * @return
	 */
	public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        System.out.println(basePath +"/"+ path);
		return basePath +"/"+ path;
	}
	
	/**
	 * This method is use for configuration of properties file
	 * @param cls
	 * @return
	 */
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(getResourcePath("src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
	}
	
   /**
    * This method will help us to read the data from properties files
    * @param key
    * @return
    * @throws IOException
    */
	
	public  String readPropertiesFile(String key) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      String propValue=null;
	      try {
	         fis = new FileInputStream(getResourcePath("src/main/resources/configfile/config.properties"));
	         prop = new Properties();
	         prop.load(fis);
	         propValue=prop.getProperty(key);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return propValue;
	   }
	
}
