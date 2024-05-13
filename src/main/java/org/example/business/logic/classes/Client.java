package org.example.business.logic.classes;

import org.example.model.classes.dto.ClientT;
import org.example.business.logic.utility.AddressValidator;
import org.example.business.logic.utility.IdValidator;
import org.example.business.logic.utility.PersonNameValidator;
import org.example.business.logic.utility.PhoneNumberValidator;

/**
 * Represents a possible client with a name, a phone number, an address and an id.
 * @param name The client's possible name.
 * @param phoneNumber The client's possible phone number.
 * @param address The client's possible address.
 * @param id The client's possible unique identifier.
 * @author L7aur
 */
public record Client(String name, String phoneNumber, String address, String id) {

    /**
     * Constructor.
     * @param name The client's possible name.
     * @param phoneNumber The client's possible phone number.
     * @param address The client's possible address.
     */
    public Client(String name, String phoneNumber, String address) {
        this(name, phoneNumber, address, null);
    }

    /**
     * Constructor.
     */
    public Client() {
        this(null, null, null, null);
    }

    /**
     * Constructor.
     * @param id The client's possible unique identifier.
     */
    public Client(String  id) {
        this(null, null, null, id);
    }

    /**
     * Checks if the fields are valid data for a client entity by means of validators.
     * @return The client entity model or null.
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
