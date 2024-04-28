package com.contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " already exists");
        }
        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }
        contacts.remove(contactId);
        Contact.removeContactId(contactId);
    }

    public void updateContactField(String contactId, String fieldName, String value) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }
        switch (fieldName.toLowerCase()) {
            case "firstname":
                contact.setFirstName(value);
                break;
            case "lastname":
                contact.setLastName(value);
                break;
            case "phone":
                contact.setPhone(value);
                break;
            case "address":
                contact.setAddress(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
