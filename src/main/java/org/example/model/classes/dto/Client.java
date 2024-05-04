package org.example.model.classes.dto;

import org.example.business.logic.classes.ClientT;
import org.example.model.utility.AddressValidator;
import org.example.model.utility.IdValidator;
import org.example.model.utility.PersonNameValidator;
import org.example.model.utility.PhoneNumberValidator;

/**
 *  The client model
 * @author L7aur
 */
public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private String id;

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Client() {
    }

    public Client(String name, String phoneNumber, String address, String id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
    }

    public Client(String  id) {
        this.id = id;
    }

    public ClientT convertToEntity() {
        try {
            PersonNameValidator.getValidator().validate(this);
            AddressValidator.getValidator().validate(this);
            PhoneNumberValidator.getValidator().validate(this);
            IdValidator.getValidator().validate(this.id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return null;
        }
        if(this.id == null && this.name == null)
            return new ClientT();
        if(this.name == null)
            return new ClientT(Integer.parseInt(this.id));
        if(this.id == null)
            return new ClientT(this.name, this.phoneNumber, this.address);
        return new ClientT(this.name, this.phoneNumber, this.address, Integer.parseInt(this.id));
    }

    public String  getId() {
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
