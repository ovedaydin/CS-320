package com.contactservice;
import java.util.ArrayList;

public class Contact {
	private static final int MAX_ID_LENGTH = 10;
	private static final int MAX_NAME_LENGTH = 10;
	private static final int MAX_ADDRESS_LENGTH = 30;
	private static final int PHONE_LENGTH = 10;
	
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private static final ArrayList<String> contactIdList = new ArrayList<>();
    

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
    	if (contactId == null || contactId.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Contact ID must not be null and must be at most 10 characters long");
        }
    	if (contactIdList.contains(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        if (firstName == null || firstName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("First name must not be null and must be at most 10 characters long");
        }
        if (lastName == null || lastName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name must not be null and must be at most 10 characters long");
        }
        if (phone == null || phone.length() != PHONE_LENGTH) {
            throw new IllegalArgumentException("Phone number must be exactly 10 characters long");
        }
        if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must not be null and must be at most 30 characters long");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        contactIdList.add(contactId);
    }
    
    // Static method to flush contactIdList
    public static void clearContactIdList() {
        contactIdList.clear();
    }
    
    public static void removeContactId(String contactId) {
        contactIdList.remove(contactId);
    }
    

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
    	if (firstName == null || firstName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("First name must not be null and must be at most 20 characters long");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
    	if (lastName == null || lastName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name must not be null and must be at most 20 characters long");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
    	if (phone == null || phone.length() != PHONE_LENGTH) {
            throw new IllegalArgumentException("Phone number must be exactly 10 characters long");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
    	if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must not be null and must be at most 30 characters long");
        }
        this.address = address;
    }
}
