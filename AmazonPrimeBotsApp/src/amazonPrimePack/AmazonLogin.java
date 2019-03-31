package amazonPrimePack;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;



public class AmazonLogin {
	
	public static WebDriver driver;
	public static String strFirstItem, strSelected;
	public static Logger log;
	

	public static void main(String[] args) {
				
		//xPathLocal = new xPathDeclaration();
		
		initWebDriver(xPathDeclaration.strBaseURL);
		
		amazonLogin();
		
		log.debug("Sign-in successful to: " + xPathDeclaration.strBaseURL );
		
		//emptyCart();		
		
		Navigation();
		
		log.debug("Selecting an item "  );
		
		selectitem();

		//  compare the item displaying same as selected**************
		strSelected = driver.findElement(By.xpath(xPathDeclaration.strxPathProductTitle)).getText();
			
		if (strFirstItem.equals(strSelected))
		{
			//System.out.println("The first Item: " + strSelected +" has been selected successfully");
			log.debug("The first Item: " + strSelected +" has been selected successfully" );
		}	
		else
		{
			//System.out.println("Selected Item" + strSelected + " doesn't match with first listed item "+ strFirstItem);
			log.debug("Selected Item" + strSelected + " doesn't match with first listed item "+ strFirstItem);
			
		}
			
		driver.findElement(By.xpath(xPathDeclaration.strxPathGiftAmount)).click(); //Gift Amount $25
		
		//implicit wait is not working
		try{
		Thread.sleep(5000);
		}
		catch(InterruptedException ie){
		}
		
		driver.findElement(By.xpath(xPathDeclaration.strxPathAddtoCart)).click();
		driver.findElement(By.xpath(xPathDeclaration.strxPathViewCart)).click(); 
		
		CartProductValidation();
		
		driver.findElement(By.xpath(xPathDeclaration.strxPathProceedToCheckout)).click();    //Proceed to Checkout
		driver.findElement(By.xpath(xPathDeclaration.strxPathShippingAddress)).click();  //Select Shipping address
		driver.findElement(By.xpath(xPathDeclaration.strxPathShippingOption)).click();     //Delivery Date 
		driver.findElement(By.xpath(xPathDeclaration.strxPathProceed)).click();    //Proceed
		//System.out.println("Closing session.. BYE");
		log.debug("Closing session.. BYE");
		
		//driver.close();
		driver.quit();
		
		
	}

	private static void CartProductValidation() {
		
		//Check the product added in cart by re-launching the product URL in a new window
		String strHrefURL = driver.findElement(By.xpath(xPathDeclaration.strxPathProductURLinCart)).getAttribute("href");
		
		//System.out.println("Product URL in cart:   "+ strHrefURL);
		log.debug("Product URL in cart:   "+ strHrefURL);
		//WebDriver driver2 = new ChromeDriver();
		WebDriver driver2 = new FirefoxDriver();
		driver2.get(strHrefURL);
		//driver2.manage().window().maximize();
		String strSelectedProduct = driver2.findElement(By.xpath(xPathDeclaration.strxPathProductTitle)).getText();
		
		if (strSelectedProduct.equals(strSelected))
		{
			//System.out.println("Selected product and product added to cart matches");
			log.debug("Product: "+ strSelectedProduct +" added in Cart matches with required Product: " + strSelected);
		}	
		else
		{
			//System.out.println("Product: "+ strSelectedProduct +" added in Cart doesn't match with required Product: " + strSelected);
			log.debug("Product: "+ strSelectedProduct +" added in Cart doesn't match with required Product: " + strSelected);
		}
		//driver2.close();
		driver2.quit();
	}

	private static void selectitem() {
		
		try{
		Thread.sleep(3000);
		}
		catch(InterruptedException ie){
		}
		/*
		Select sort=new Select(driver.findElement(By.xpath(xPathDeclaration.strxPathSortList)));
		driver.findElement(By.xpath(xPathDeclaration.strxPathSortList)).
		try{
		Thread.sleep(9000);
		}
		catch(InterruptedException ie){
		}
		sort.selectByIndex(2);*/
		
		driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]")).click();
		
		
		//Get first item in the list and click on it
		strFirstItem = driver.findElement(By.xpath(xPathDeclaration.strxPathFindFirstItem)).getText();
		//System.out.println("First Item In the List: " + strFirstItem);
		log.debug("First Item In the List: " + strFirstItem);
		
		driver.findElement(By.xpath(xPathDeclaration.strxPathSelectFirstItem)).click(); //To select first item
		
	}

	private static void emptyCart() {

		driver.findElement(By.xpath(xPathDeclaration.strxPathCart)).click();
		driver.findElement(By.xpath(xPathDeclaration.strxPathDeleteItem)).click();
		
	}

	private static void Navigation() {

		driver.findElement(By.xpath(xPathDeclaration.strxPathGiftCards)).click(); //Gift Cards
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try{
		Thread.sleep(1000);
		}
		catch(InterruptedException ie){
		}
		driver.findElement(By.xpath(xPathDeclaration.strxPathDeliveryType)).click(); //Mail;
	}

	private static void amazonLogin() {

		driver.findElement(By.xpath(xPathDeclaration.strxPathSigninPage)).click();  //sign in page

		log.debug("Sign-in into " + xPathDeclaration.strBaseURL );
		
		//driver.findElement(By.xpath(xPathLocal.strxPathUserName)).sendKeys(strUserID); //User Name
		WebElement UserName = driver.findElement(By.xpath(xPathDeclaration.strxPathUserName));
		UserName.sendKeys(xPathDeclaration.strUserID);

		//driver.findElement(By.xpath(xPathLocal.strxPathPassword)).sendKeys(strPwd); //Password
		WebElement Password = driver.findElement(By.xpath(xPathDeclaration.strxPathPassword));
		Password.sendKeys(xPathDeclaration.strPwd);
		

		driver.findElement(By.xpath(xPathDeclaration.strxPathSignin)).click(); //signin button
	}

	private static void initWebDriver(String strURL) {

		//System.setProperty("webdriver.chrome.driver", xPathDeclaration.strChromeDriverExePath );
		System.setProperty("webdriver.gecko.driver", xPathDeclaration.strFireFoxDriverExePath );
		log = Logger.getLogger("devpinoyLogger");
		log.debug("Updated System Path and Lanching the website: " + xPathDeclaration.strBaseURL );
		
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get(xPathDeclaration.strBaseURL);
		driver.manage().window().maximize();

	}

}
