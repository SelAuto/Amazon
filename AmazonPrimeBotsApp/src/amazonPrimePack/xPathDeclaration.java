package amazonPrimePack;

//import org.openqa.selenium.WebDriver;

public class xPathDeclaration {
	
	
	public static final String strChromeDriverExePath = "C:\\Bujji\\Learning\\SupportingJARFiles\\chromedriver.exe";
	public static final String strFireFoxDriverExePath = "C:\\Bujji\\Learning\\SupportingJARFiles\\geckodriver.exe";
	public static final String strBaseURL = "https://www.amazon.com";
	public static String strFirstItem, strSelected;
	public static final String strxPathSigninPage = "//*[@id=\"nav-link-accountList\"]";
	public static final String strxPathUserName = "//*[@id=\"ap_email\"]";
	public static final String strxPathPassword = "//*[@id=\"ap_password\"]";
	public static final String strxPathSignin = "//*[@id=\"signInSubmit\"]";
	public static final String strUserID = "SeleniumToautomate@gmail.com";
	public static final String strPwd = "s@automate";
	public static final String strxPathGiftCards = "//*[@id=\"nav-xshop\"]/a[4]";
	public static final String strxPathDeliveryType = "//img[contains(@alt, 'Mail')]";
	public static final String strxPathSortList = "//*[@id=\"s-result-sort-select\"]";
	public static final String strxPathCart = "//*[@id=\"nav-cart\"]";
	public static final String strxPathDeleteItem = "//span[@class='a-size-small sc-action-delete']";
	public static final String strxPathFindFirstItem = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/h5/a/span";
	public static final String strxPathSelectFirstItem = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/h5/a";
	public static final String strxPathProductTitle = "//*[@id=\"productTitle\"]";
	public static final String strxPathGiftAmount = "//*[@id=\"a-autoid-10\"]";
	public static final String strxPathAddtoCart = "//*[@id=\"add-to-cart-button\"]";
	public static final String strxPathViewCart = "//*[@id=\"hlb-view-cart-announce\"]";
	public static final String strxPathProductURLinCart = "//a[@class='a-link-normal sc-product-link']";
	public static final String strxPathProceedToCheckout = "//*[@id=\"sc-buy-box-ptc-button\"]/span/input";	
	public static final String strxPathShippingAddress = "//*[@id=\"address-book-entry-0\"]/div[2]/span/a";
	public static final String strxPathShippingOption = "//*[@id=\"shippingOptionFormId\"]/div[2]/div/div[2]/div/div[3]/div/div[1]/div/div/div[2]/span/span[1]/strong";
	public static final String strxPathProceed = "//*[@id=\"shippingOptionFormId\"]/div[1]/div[2]/div/span[1]/span/input";

}
