package pages;

import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class ContactPage extends BasePage{

        @FindBy(id = "lastName")
        public WebElement lastNameInput;

        @FindBy(id = "combobox-input-497")
        public WebElement searchAccountsInput;

        @FindBy(xpath = "//*[@title='contactLastName']")
        public WebElement contactLink;

        public ContactPage(WebDriver driver) {
            super(driver);
        }

        public ContactPage openPage(String url){
            driver.get(url);
            return this;
        }

        public HomePage createNewContact(String lastName){
            lastNameInput.sendKeys(lastName);
            searchAccountsInput.click();
            return new HomePage(driver);
        }

        public HomePage contactPageId (Contact contact){
            contactLink.click();
            return new HomePage(driver);
        }

        public static final String DATA_BY_FIELD_NAME_XPATH = "//a[contains(@href, '/lightning/r/Account/') and contains(text(), '%s')]";

        public String getStringValueByName(String name){
            return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
        }
    }
