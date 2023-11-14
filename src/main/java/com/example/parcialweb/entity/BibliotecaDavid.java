package com.example.parcialweb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bibliotecaDavid")
public class BibliotecaDavid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_biblioteca;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name="ciudad")
    private String ciudad;

}

