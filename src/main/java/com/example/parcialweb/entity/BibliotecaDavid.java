package com.example.parcialweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bibliotecaDavid")
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecaDavid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_biblioteca;

    private String nombre;
    private String direccion;
    private String ciudad;

}

