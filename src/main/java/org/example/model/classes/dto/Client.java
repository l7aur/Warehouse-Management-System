package org.example.model.classes.dto;

import org.example.business.logic.classes.ClientT;
import org.example.business.logic.utility.AddressValidator;
import org.example.business.logic.utility.NameValidator;
import org.example.business.logic.utility.PhoneNumberValidator;

/**
 *  The client model
 * @author L7aur
 */
public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private int id;

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public Client() {
    }

    public Client(String name, String phoneNumber, String address, int id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
    }

    public Client(int id) {
        this.name = null;
        this.phoneNumber = null;
        this.address = null;
        this.id = id;
    }

    public ClientT convertToEntity(){
        ClientT entity = new ClientT();
        if(this.name != null && this.address != null && this.phoneNumber != null) {
            try {
                NameValidator.getValidator().validate(this);
                AddressValidator.getValidator().validate(this);
                PhoneNumberValidator.getPhoneNumberValidator().validate(this);
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
                return null;
            }
        }
        entity.setAll(this.name, this.phoneNumber, this.address, this.id);
        return entity;
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
}
