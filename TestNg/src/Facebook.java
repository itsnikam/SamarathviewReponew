import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Facebook {

	
	public static WebDriver dr = null;
	@Test
	public void test1()
	{
		Logger log = Logger.getLogger("devpinoyLogger");
		log.debug("opening the browser");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sony\\Desktop\\Samarthview\\geckodriver.exe");
		dr = new FirefoxDriver();
		dr.navigate().to("https://www.facebook.com");
		log.debug("Navigating to facebook");
	    
		
	}
	
}
