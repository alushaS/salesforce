package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage{

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public static final String TABLE_XPATH = "//table";
    public static final String CONTACT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";

    public ContactListPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public String getExistContactName(String contactFirstName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactFirstName))).getText();
    }
}
