package org.example.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLIENT")
public class ClientUser extends  User {

    public ClientUser() {
        super();
    }

    public ClientUser(int id, String nombre, String email) {
        super(id, nombre, email);
    }
}
