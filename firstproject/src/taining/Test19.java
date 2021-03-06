package taining;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test19
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String b=sc.nextLine();
		if(b.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver.exe");
        driver=new ChromeDriver();
		}
		else if(b.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","H:\\Selenium\\geckodriver.exe");
	        driver=new FirefoxDriver();	
		}
		else if(b.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","H:\\Selenium\\IEDriverserver.exe");
	        driver=new InternetExplorerDriver();
		}
		else if(b.equalsIgnoreCase("opera"))
		{
			OperaOptions c=new OperaOptions();
			c.setBinary("C:\\Program Files\\Opera\\53.0.2907.99\\opera.exe");
			System.setProperty("webdriver.opera.driver","H:\\Selenium\\operadriver.exe");
	        driver=new OperaDriver(c);
		}
		else
		{
			System.out.println("invalid browser name");
			System.exit(0);
		}
		//launch site
		driver.get("http://www.google.co.in");
		//maximize window
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Enter text to Auto-Complete
		//To get Suggestion
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		a.sendKeys(e,"kalam").build().perform();
		Thread.sleep(1000);
		//Select 4th item in Suggestion list
		int i=1;
		for(i=1;i<=10;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(4000);
		}
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		//close
		driver.close();
	}
}
