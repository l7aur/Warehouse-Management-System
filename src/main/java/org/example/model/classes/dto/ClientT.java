package org.example.model.classes.dto;

import org.example.data.access.classes.ClientDAO;

/**
 * Client data transfer object.
 * @param name The name of the client.
 * @param phoneNumber The phone number of the client.
 * @param address The address of the client.
 * @param id The unique identifier of the client.
 * @author L7aur
 */
public record ClientT(String name, String phoneNumber, String address, int id) {

    /**
     * Constructor.
     * @param id The unique identifier of the client.
     */
    public ClientT(int id){
        this(null, null, null,id);
    }

    /**
     * Constructor.
     */
    public ClientT(){
        this(null, null, null,0);
    }

    /**
     * Constructor.
     * @param name The name of the client.
     * @param phoneNumber The phone number of the client.
     * @param address The address of the client.
     */
    public ClientT(String name, String phoneNumber, String address) {
        this(name, phoneNumber, address, 0);
    }

    /**
     * Creates a client data abstract object.
     * @return A client data abstract object.
     */
    public ClientDAO convertToDAO() {
        return new ClientDAO();
    }

    /**
     * Creates the printable version of the client data transfer object.
     * @return A string representing the printable version of the client data transfer object.
     */
    @Override
    public String toString() {
        return name;
    }
}
