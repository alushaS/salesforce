package pages;

import objects.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@class='record-body-container']//*[(text()='%s')]";

    @FindBy(xpath = "//a[contains(@title, 'account')]")
    public WebElement accountLink;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValueByName(String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }

    public NewAccountModalPage accountPageId (Account account){
        accountLink.click();
        return new NewAccountModalPage(driver);
    }
}
