import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ArinaFTest extends Base{
    @Test(priority = 0)//execute first
    public void firstTest() {
        final String expectedLogoText = "Internet Brands";
        getDriver().get("https://www.internetbrands.com");
        WebElement logo = getDriver().findElement(By.xpath("//img[@alt='Internet Brands Logo']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(priority = 1)//execute second
    public void secondTest() {
        getDriver().get("https://www.webstaurantstore.com/");

        String text="table";
        getDriver().findElement(By.id("searchval")).sendKeys(text+"\n"); ////input[@tabindex='2'] Byxpath
        getDriver().findElement(By.xpath("//button[@value='Search']")).click();
        List<WebElement> itemList = getDriver().findElements(By.xpath("//div[@id='details']/a[contains(@class,'block font')] "));


        //Via css: #details >.block
        //Via data-testid: //div[@id='details']/a[@data-testid='itemDescription']
        //Via contains function: //div[@id='details']/a[contains(@class,'block')]
        for (int i = 0; i < itemList.size(); i++) {
            Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("table"));
        }

    }

    @Test(priority = 2)//execute last
    public void textTest(){
        final String expectedLogoText = "VERTICALLY FOCUSED";
        getDriver().get("https://www.internetbrands.com");
        WebElement mainBanner = getDriver().findElement(By.className("main-title"));
        Assert.assertEquals(mainBanner.getText(), expectedLogoText);


    }




}
