package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage{

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public static final String TABLE_XPATH = "//table";
    public static final String CONTACT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String ACCOUNT_NAME_ON_CONTACT_PAGE_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String CONTACT_PHONE_XPATH = TABLE_XPATH + "//span[contains(@class, 'forceOutputPhone')]";

    public ContactListPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public String getExistContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).getText();
    }

    public String getExistAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_ON_CONTACT_PAGE_XPATH, accountName))).getText();
    }

    public String getContactPhone(String phone) {
        return driver.findElement(By.xpath(String.format(CONTACT_PHONE_XPATH, phone))).getText();
    }
}
