package com.example.parcialweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "libro_david")
@AllArgsConstructor
@NoArgsConstructor
public class LibroDavid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_libro;

    private String nombre;

    private String autor;

    @OneToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_biblioteca")
    private BibliotecaDavid biblioteca;
}


