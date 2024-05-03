package org.example.business.logic.classes;

import org.example.data.access.classes.ClientDAO;

public class ClientT {
    private String name;
    private String phoneNumber;
    private String address;
    private int id;

    public ClientT(){

    }

    public void setAll(String name, String phoneNumber, String address, int id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
    }

    public ClientDAO convertToDAO() {
        return new ClientDAO();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ClientT [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }
}
