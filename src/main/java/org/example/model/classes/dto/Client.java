package org.example.model.classes.dto;

import org.example.business.logic.classes.ClientT;
import org.example.model.utility.AddressValidator;
import org.example.model.utility.IdValidator;
import org.example.model.utility.PersonNameValidator;
import org.example.model.utility.PhoneNumberValidator;

/**
 *  The client data transfer object
 * @author L7aur
 */
public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private String id;

    /**
     * Parameterised constructor
     * @param name the name of the client
     * @param phoneNumber the phone number of the client
     * @param address the address of the client
     */
    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Empty constructor
     */
    public Client() {
    }

    /**
     * Parameterised constructor used when fetching data
     * @param name name of the client
     * @param phoneNumber phone number of the client
     * @param address address of the client
     * @param id id of the client
     */
    public Client(String name, String phoneNumber, String address, String id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
    }

    /**
     * Parameterised constructor
     * @param id id of the client
     */
    public Client(String  id) {
        this.id = id;
    }

    /**
     * Checks if the fields are valid data for a Client Entity
     * If they are
     * @return the entity model of the client abstract data type
     * else
     * handles as exception
     */
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

    /**
     * Getter
     * @return the id of the client
     */
    public String getId() {
        return id;
    }

    /**
     * Getter
     * @return the name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name the new name of the client
     */
    public void setName(String name) {
        this.name = name;
        try {
            PersonNameValidator.getValidator().validate(this);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Getter
     * @return the phone number of the client
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter
     * @param phoneNumber the new phone number of the client
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        try {
            PhoneNumberValidator.getValidator().validate(this);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Getter
     * @return the address of the client
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter
     * @param address the new address of the client
     */
    public void setAddress(String address) {
        this.address = address;
        try {
            AddressValidator.getValidator().validate(this);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
}
