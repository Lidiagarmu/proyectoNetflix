package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLIENT")
public class ClientUser extends  User {
/*
    @Column(name = "user_type", insertable = false, updatable = false)
    private String userType; // Este atributo es solo para referencia, no persiste en la base de datos
*/
    public ClientUser() {
        super();
    }

    public ClientUser(int id, String nombre, String email) {
        super(id, nombre, email);
    }
}
