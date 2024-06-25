package org.example.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Esto indica que todas las entidades hijas (AdminUser, ClientUser) se almacenarán en una sola tabla junto con la entidad padre (User).
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING) //Estas anotaciones se utilizan para especificar el nombre de la columna discriminadora (user_type en este caso) y los valores discriminatorios que identifican a cada subclase (ADMIN y CLIENT).
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name="nombre")
    private String nombre;

    @Column (name="email")
    private String email;



    // Constructor sin argumentos (necesario para Hibernate)

    public User() {
    }

    // Constructor con argumentos

    public User(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "USUARIO: " + nombre +
                "\nID: " + id +
                "\nEMAIL: " + email
                ;
    }
}
