package org.example.business.logic.classes;

import org.example.model.classes.dto.ClientT;
import org.example.business.logic.utility.AddressValidator;
import org.example.business.logic.utility.IdValidator;
import org.example.business.logic.utility.PersonNameValidator;
import org.example.business.logic.utility.PhoneNumberValidator;

/**
 *  The client data transfer object
 * @author L7aur
 */
public record Client(String name, String phoneNumber, String address, String id) {

    /**
     * Parameterised constructor
     * @param name the name of the client
     * @param phoneNumber the phone number of the client
     * @param address the address of the client
     */
    public Client(String name, String phoneNumber, String address) {
        this(name, phoneNumber, address, null);
    }

    /**
     * Empty constructor
     */
    public Client() {
        this(null, null, null, null);
    }

    /**
     * Parameterised constructor
     * @param id id of the client
     */
    public Client(String  id) {
        this(null, null, null, id);
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
            PersonNameValidator.getValidator().validate(this.name);
            AddressValidator.getValidator().validate(this.address);
            PhoneNumberValidator.getValidator().validate(this.phoneNumber);
            IdValidator.getValidator().validate(this.id);
        } catch (IllegalArgumentException e) {
            System.out.println("<EXCEPTION> Client.java");
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
}
