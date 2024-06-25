package org.example.entity;


import jakarta.persistence.*;

@Entity
@Table (name ="peliculas")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name="nombre")
    private String nombre;

    @Column (name="director")
    private String director;

    @Column (name="genero")
    private String genero;

    @Column (name="ano")
    private String ano ;


    // Constructor sin argumentos (necesario para Hibernate)

    public Film() {
    }

    // Constructor con argumentos

    public Film(int id, String nombre, String director, String genero, String ano) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.ano = ano;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }


    @Override
    public String toString() {
        return "\nTÍTULO: " + nombre +
                "\n----------------------" +
                "\nid: " + id +
                "\ndirector: " + director +
                "\ngénero: " + genero  +
                "\naño: " + ano;
    }
}
