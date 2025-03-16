package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {
    WebDriver driver;
    String label;

    private static final String ACCOUNT_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH = "//*[contains(@title, '--None--')]";
    private static final String CONTACT_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//input[@placeholder='Search Accounts...']";
    private static final String CONTACT_DROPDOWN_OPTION_XPATH = "//*[contains(@title, 'account-1555416495')]";

    public Dropdown(WebDriver driver, String label) {
        this.label = label;
        this.driver = driver;
    }

    public void accountSelectOption(String option){
        driver.findElement(By.xpath(String.format(ACCOUNT_DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, label))).click();
    }

    public void contactSelectOption(String option) {
        driver.findElement(By.xpath(String.format(CONTACT_DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(CONTACT_DROPDOWN_OPTION_XPATH, label))).click();
    }
}