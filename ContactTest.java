package com.contactservice;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ContactTest {
	
	@BeforeEach
    void setUp() {
        Contact.clearContactIdList();
    }

    @Test
    void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    
    @Test
    void testContactCreationDuplicate() {
    	Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
        	   new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        });
     

    }
    
    @Test
    void testRemoveContactID() {
    	String contatctId = "1234567890";
    	Contact contact1 = new Contact(contatctId, "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact1);
        Contact.removeContactId(contatctId);
        Contact contactNew =new Contact(contatctId, "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contactNew);

    }
    
    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
        	   new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });

    }

    @Test
    void testFirstNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
        });
    }
    

    @Test
    void testLastNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "1234567890", "123 Main St");
        });
    }
    

    @Test
    void testPhoneNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });
    }

    @Test
    void testAddressNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    void testContactIdLengthLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testFirstNameLengthLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Johnnnnnnnnn", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testLastNameLengthLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doeeeeeeeeee", "1234567890", "123 Main St");
        });
    }

    @Test
    void testPhoneLengthLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345678901", "123 Main St");
        });
    }

    @Test
    void testAddressLengthLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", "1234567890123456789012345678901");
        });
    }
    
    @Test
    void testFirstNameSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testLastNameSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testPhoneSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }

    @Test
    void testAddressSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void testNullFirstNameSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }
    
    @Test
    void testLongFirstNameSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName( "John".repeat(10));
        });
    }

    @Test
    void testNullLastNameSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }
    
    @Test
    void testLongLastNameSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("Doe".repeat(10));
        });
    }

    @Test
    void testNullPhoneSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }
    
    @Test
    void testShortPhoneSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
    }

    @Test
    void testNullAddressSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
    
    @Test
    void testLongAddressSetter() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("123 Main St".repeat(10));
        });
    }
   

}

