package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import objects.Account;
import objects.Contact;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTest extends BaseTest{

    Random random = new Random();

    @Test
    public void createContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt());
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80296546635");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setContactLastName("contactLastName");
        contact.setPhone("784578456");
        contact.setAccountName(account.getAccountName());
        contact.setEmail("johndoe@gmail.com");
        loginPage.openPage(LOGIN_URL)
                .login(userName, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(contactListPage.getExistContactName(contact.getContactLastName()), (contact.getContactLastName()));
        Assert.assertEquals(contactListPage.getExistAccountName(contact.getAccountName()), contact.getAccountName());
        Assert.assertEquals(contactListPage.getContactPhone(contact.getPhone()), contact.getPhone());
    }

    @Test
    public void checkNewContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt());
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80296546637");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setContactLastName("contactLastName");
        contact.setPhone("784578456");
        loginPage.openPage(LOGIN_URL)
                .login(userName, password);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);
        contactPage.contactPageId(contact);
        Assert.assertEquals(contactListPage.getExistContactName(contact.getContactLastName()), contact.getContactLastName());
        Assert.assertEquals(contactPage.getStringValueByName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(contactListPage.getContactPhone(contact.getPhone()), contact.getPhone());
    }
}
