package com.HiFriend.HiFriend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;


public class Demo {
    private WebDriver driver;

    @Before
    public void setUp(){
    System.setProperty("webdriver.chrome.driver" , "./src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("www.google.com");
    }
    
}



