/*
 * Copyright 2012-2020 CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.codelibs.fess.crawler.client.http.WebDriverClientJS;




import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait; 

/**
 * @author shinsuke
 *
 */
public class WebDriverClientJS {

    public Object getTextWebPage (final String baseUrl, final String driverPath){  

        // public static String baseUrl = "https://agrows-portal-r3.labbs.com.br/documentacao/comecar";  
        // static String driverPath = "/Users/lucasdealmeida/Documents/projects/fess-bb/chrome-webdriver/chromedriver";    
           
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        // set the system property for Chrome driver      
        System.setProperty("webdriver.chrome.driver", driverPath); 
    
        System.setProperty("webdriver.chrome.silentOutput", "true");
    
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.setBinary("/usr/bin/chromium");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--silent");
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
    
    
        final WebDriver driver = new ChromeDriver(chromeOptions);
    
    
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
        driver.manage().window().maximize(); 
    
        // System.out.println("\n\n"); 
    
    
        driver.get(baseUrl);  

        // get the current URL of the page  
        // String URL= driver.getCurrentUrl();  
        // System.out.println(URL);  
        //get the title of the page  
        // String title = driver.getTitle();       
    
    
        // System.out.println(title);  
        // System.out.println("\n\n"); 
    
        //  System.out.println(driver.getPageSource());  

        final String readableBody = new String((
                                                driver.getCurrentUrl().toString()+"\n"
                                                +driver.getTitle().toString()+"\n"
                                                +driver.findElement(By.tagName("body")).getText().toString()
                                                ));
        
        driver.quit();

        return  readableBody;  
    
    }    

}
