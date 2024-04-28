package com.contactservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact1;
    
    @BeforeEach
    public void setUp() {
    	Contact.clearContactIdList();
        contactService = new ContactService();
        contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact1);
    }

    @Test
    public void testAddContact() {
        Assertions.assertEquals(contact1, contactService.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        contactService.deleteContact("1");
        Assertions.assertNull(contactService.getContact("1"));
    }
    
    @Test
    public void testDeleteAndAddContact() {
        contactService.deleteContact("1");
        Assertions.assertNull(contactService.getContact("1"));
        new Contact("1", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testUpdateContactField() {
        contactService.updateContactField("1", "firstName", "Joe");
        Assertions.assertEquals("Joe", contactService.getContact("1").getFirstName());
        contactService.updateContactField("1", "lastname", "Smith");
        Assertions.assertEquals("Smith", contactService.getContact("1").getLastName());
        contactService.updateContactField("1", "phone", "1234567891");
        Assertions.assertEquals("1234567891", contactService.getContact("1").getPhone());
        contactService.updateContactField("1", "address", "123 New Main St");
        Assertions.assertEquals("123 New Main St", contactService.getContact("1").getAddress());
        
    }

    @Test
    public void testGetContact() {
        Assertions.assertEquals(contact1, contactService.getContact("1"));
    }

    @Test
    public void testAddDuplicateContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact1));
    }

    @Test
    public void testDeleteNonExistingContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("3"));
    }

    @Test
    public void testUpdateNonExistingContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("3", "firstname", "Adam"));
    }

    @Test
    public void testUpdateInvalidField() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("1", "invalid", "value"));
    }

    @Test
    public void testNullContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.addContact(null));
    }
}
