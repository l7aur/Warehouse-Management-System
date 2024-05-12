package org.example.model.classes.dto;

import org.example.data.access.classes.ClientDAO;

public class ClientT {
    private String name;
    private String phoneNumber;
    private String address;
    private int id;

    public ClientT(int id){
        this.id = id;
    }

    public ClientT(){
    }

    public ClientT(String name, String phoneNumber, String address, int id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
    }

    public ClientT(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name;
    }
}
