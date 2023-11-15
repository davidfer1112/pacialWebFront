package com.example.parcialweb.dto;

import com.example.parcialweb.entity.BibliotecaDavid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BibliotecaDavidDTO {

    private String nombre;
    private String direccion;
    private String ciudad;

}


