package selenium_api;
/**
 * @author shaojie
 * @email 1115041402@qq.com
 */
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumAPI {
	WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	public void send(){
		Email e = new  Email();
		e.send_mail();
	}
	/**
	 * 元素定位
	 * @param css 元素的key和值
	 * @return
	 * @usage this.find_element("id->kw")
	 */
	public WebElement find_element(String css){
		WebElement ele = null;
		String key = css.split("->")[0];
		String value = css.split("->")[1];
		if(key.equals("id")){
			 ele = driver.findElement(By.id(value));
		}else if(key.equals("name")){
			 ele = driver.findElement(By.name(value));
		}else if(key.equals("css")){
			 ele = driver.findElement(By.cssSelector(value));
		}else if(key.equals("xpath")){
			 ele = driver.findElement(By.xpath(value));
		}else if(key.equals("class")){
			 ele = driver.findElement(By.className(value));
		}else if(key.equals("link")){
			 ele = driver.findElement(By.linkText(value));
		}else{
			System.out.println("请检查定位元素是否正确....");
		}
		return ele;	
	}
	/**
	 * 点击某个元素
	 * @param css
	 */
	public void click(String css){
		WebElement ele = this.find_element(css);
		ele.click();
		
	}
	/**
	 * 输入文本内容
	 * @param css
	 * @param text
	 */
	public void sendkeys(String css,String text){
		WebElement ele = this.find_element(css);
		System.out.println(ele);
		ele.sendKeys(text);
	}
	/**
	 * 获取浏览器标题
	 * @return
	 */
	public String get_title(){
		return driver.getTitle();
	}
	/**
	 * 获取当前的url
	 * @return
	 */
	public String get_url(){
		return driver.getCurrentUrl();
	}
	/**
	 * 获取当前的handle
	 * @return
	 */
	public String get_handle(){
		return driver.getWindowHandle();
	}
	/**
	 * 获取所有的handles列表
	 * @return
	 */
	public Set<String> get_handles(){
		return driver.getWindowHandles();
	}
	/**
	 * 打开网站
	 * @param url
	 */
	public void open(String url){
		driver.get(url);
	}
	public void back(){
		driver.navigate().back();
	}
	public void forward(){
		driver.navigate().forward();
	}
	public void close(){
		driver.close();
	}
	public void quit(){
		driver.quit();
	}
	/**
	 * 浏览器最大化
	 */
	public void max_windows(){
		driver.manage().window().maximize();
	}
	public void switch_to_frame(String iframe){
		driver.switchTo().frame(iframe);
	}
	public void back_to_frame(){
		driver.switchTo().defaultContent();
	}
	public Alert alert(){
		return driver.switchTo().alert();
	}
	public void dismiss(){
		this.alert().dismiss();
	}
	public void accpet(){
		this.alert().accept();
	}
	public void get_alert_text(){
		this.alert().getText();
	}
	public void send_alert_text(String text){
		this.alert().sendKeys(text);
	}
	public Select return_select(String css){
		Select select = new Select(this.find_element(css));
		return select;
	}
	public void select_by_index(String css,int index){
		this.return_select(css).selectByIndex(index);
	}
	public void select_by_text(String css,String text){
		this.return_select(css).selectByVisibleText(text);
	}
	public void select_by_value(String css,String value){
		this.return_select(css).selectByValue(value);
	}
	public void get_option(String css){
		this.return_select(css).getOptions();
	}
	public void drag_and_drop(String element,String target){
		WebElement start = this.find_element(element);
		WebElement stop = this.find_element(target);
		(new Actions(driver)).dragAndDrop(start, stop).perform();
	}
	/**
	 * 判断元素是否可见
	 * @param css
	 * @usage this.wait_element("id->kw");
	 */
	public void wait_element(String css){
		new WebDriverWait(driver, 5).
		until(ExpectedConditions.
		visibilityOf(this.find_element(css)));
	}
	/**
	 * 判断标题是不是一致
	 * @param title
	 */
	public void assert_title(String title){
		new WebDriverWait(driver,5).
		until(ExpectedConditions.titleIs(title));
	}
}
