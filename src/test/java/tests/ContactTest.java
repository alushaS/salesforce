package tests;

import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTest extends BaseTest{

    Random random = new Random();

    @Test
    public void createContactTest() {
        Contact contact = new Contact();
        contact.setContactFirstName("contactName");
        contact.setContactLastName("contactLastName");
        loginPage.openPage(LOGIN_URL)
                .login(userName, password);
        newContactModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(contactListPage.getExistContactName(contact.getContactFirstName()), (contact.getContactFirstName()) + " " + contact.getContactLastName());
    }
}
