package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminUser extends User {


    public AdminUser() {
        super();
    }

    public AdminUser(int id, String nombre, String email) {
        super(id, nombre, email);
    }
}
