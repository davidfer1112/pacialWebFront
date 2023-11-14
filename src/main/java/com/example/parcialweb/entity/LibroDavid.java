package com.example.parcialweb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "libro_david")
public class LibroDavid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_libro;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "autor")
    private String autor;

    @OneToOne
    @JoinColumn(name = "id_biblioteca")
    private BibliotecaDavid biblioteca;
}


