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

    private long id_biblioteca;
    private String nombre;
    private String direccion;
    private String ciudad;

    public static BibliotecaDavidDTO fromEntity(BibliotecaDavid bibliotecaDavid) {
        return BibliotecaDavidDTO.builder()
                .id_biblioteca(bibliotecaDavid.getId_biblioteca())
                .nombre(bibliotecaDavid.getNombre())
                .direccion(bibliotecaDavid.getDireccion())
                .ciudad(bibliotecaDavid.getCiudad())
                .build();
    }

    public static BibliotecaDavid toEntity(BibliotecaDavidDTO bibliotecaDavidDTO) {
        BibliotecaDavid bibliotecaDavid = new BibliotecaDavid();
        bibliotecaDavid.setId_biblioteca(bibliotecaDavidDTO.getId_biblioteca());
        bibliotecaDavid.setNombre(bibliotecaDavidDTO.getNombre());
        bibliotecaDavid.setDireccion(bibliotecaDavidDTO.getDireccion());
        bibliotecaDavid.setCiudad(bibliotecaDavidDTO.getCiudad());
        return bibliotecaDavid;
    }
}


