package com.example.parcialweb.dto;

import com.example.parcialweb.entity.LibroDavid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroDavidMapper {

    LibroDavidMapper MAPPER = Mappers.getMapper(LibroDavidMapper.class);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "autor", target = "autor")
    LibroDavidDTO libroToLibroDTO(LibroDavid libroDavid);
}
