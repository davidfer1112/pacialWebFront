package com.example.parcialweb.dto;

import com.example.parcialweb.entity.BibliotecaDavid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BibliotecaDavidMapper {

    BibliotecaDavidMapper MAPPER = Mappers.getMapper(BibliotecaDavidMapper.class);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = " direccion", target = "direccion")
    @Mapping(source = "ciudad", target = "ciudad")
    BibliotecaDavidDTO bibliotecaToBibliotecaDTO(BibliotecaDavid bibliotecaDavid);

}
