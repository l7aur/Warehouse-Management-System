package org.example.data.access.classes.dto;

/**
 *  The client model
 * @author L7aur
 */
public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private Integer id;

    public Client(String name, String phoneNumber, String address, Integer id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
