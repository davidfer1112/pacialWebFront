package com.example.parcialweb.dto;

import com.example.parcialweb.entity.BibliotecaDavid;
import com.example.parcialweb.entity.LibroDavid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroDavidDTO {

    private long id_libro;
    private String nombre;
    private String autor;
    private long id_biblioteca;

    public static LibroDavidDTO fromEntity(LibroDavid libroDavid) {
        return LibroDavidDTO.builder()
                .id_libro(libroDavid.getId_libro())
                .nombre(libroDavid.getNombre())
                .autor(libroDavid.getAutor())
                .id_biblioteca(libroDavid.getBiblioteca().getId_biblioteca())
                .build();
    }

    public static LibroDavid toEntity(LibroDavidDTO libroDavidDTO) {
        LibroDavid libroDavid = new LibroDavid();
        libroDavid.setId_libro(libroDavidDTO.getId_libro());
        libroDavid.setNombre(libroDavidDTO.getNombre());
        libroDavid.setAutor(libroDavidDTO.getAutor());

        BibliotecaDavid biblioteca = new BibliotecaDavid();
        biblioteca.setId_biblioteca(libroDavidDTO.getId_biblioteca());
        libroDavid.setBiblioteca(biblioteca);

        return libroDavid;
    }
}

