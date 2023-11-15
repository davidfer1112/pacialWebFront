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

    private String nombre;
    private String autor;
}

