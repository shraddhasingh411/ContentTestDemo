package com.contentTest.StepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;



public class ResourcesStepDef {
	
	WebDriver wd;
	
	
	@Given ("^User is already on login page$")
	public void user_is_already_on_login_page()
	{
	   
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		wd= new ChromeDriver();
		wd.get("http://www.highschool.bfwpub.com/launchpad/spa3edemo");
		
		
	}
	
	@When("^User enters \\”(.*)\\” and \\”(.*)\\”$")
	public void user_enters_username_and_password(String usr, String pwd)
	{
	WebElement username =wd.findElement(By.xpath("//input[@class='loginInput']"));
	username.sendKeys(usr);
    WebElement password= wd.findElement(By.xpath("//input[@class='loginInput passwordField']"));
    password.sendKeys(pwd);
	}
	
	@And("^User selects SignIn button$")
	public void User_selects_SignIn_button()
	{
		WebElement signIn= wd.findElement(By.xpath("ladda-label"));
		signIn.click();
	}
		
	
	@And("^User selects the course name$")
	public void user_selects_the_course_name(String CourseName)
	{
		wd.findElement(By.partialLinkText("Starnes, Statistics and Probability with Applications 3e Demo LaunchPad")).click();
		// verify the page title
	    String getCourse= wd.findElement(By.xpath("//div[@class='ribbon-widget-wrapper-split ribbon-widget-wrapper']/div/div/div/div[@id='courseName']")).getText();
	    Assert.assertEquals(getCourse,CourseName);
	    
	}
	
	@Given("^User is on the course page$")
	public void user_is_on_the_course_page()
	{
		
	}
	
	@When("^User selects any unit$")
	public void user_selects_any_unit()
	{
		
	}
	
	@Then("^ All the chapters should appear in content$")
	public void all_the_chapters_should_appear_in_content(String filePath,String fileName,String sheetName) throws IOException	
	{
		
		File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook macWorkbook = null;

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
   

	    if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        macWorkbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet macSheet = macWorkbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = macSheet.getLastRowNum()-macSheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = macSheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();
		
		
	} }
	
	    
	   @Given("^User has selected Resources tab$")
	   public void user_has_selected_resources_tab()
	   {
		
		   WebElement resources= wd.findElement(By.xpath("//a[@title='Resources']"));
		   resources.click();
		  
		   
	   }
	   
	   
	   @When("^ User selects Content By Type$")
	   public void user_selects_Content_By_Type()
	   {
		   
		   WebElement contentByType= wd.findElement(By.xpath("//a[contains(text(),'Content by type')]"));
		   contentByType.click();
		   
	   }
	   
	   @Then("^All the resources should appear as in menuscript$")
	   public void all_the_resources_should_appear_as_in_menuscript()
	   {
		  
		   
		   
	   }
	   
	   				
}
