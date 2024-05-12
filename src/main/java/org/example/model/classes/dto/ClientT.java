package org.example.model.classes.dto;

import org.example.data.access.classes.ClientDAO;

public record ClientT(String name, String phoneNumber, String address, int id) {

    public ClientT(int id){
        this(null, null, null,id);
    }

    public ClientT(){
        this(null, null, null,0);
    }

    public ClientT(String name, String phoneNumber, String address) {
        this(name, phoneNumber, address, 0);
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
