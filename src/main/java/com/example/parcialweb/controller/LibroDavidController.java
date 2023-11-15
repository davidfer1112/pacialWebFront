package com.example.parcialweb.controller;

import com.example.parcialweb.dto.LibroDavidDTO;
import com.example.parcialweb.dto.LibroDavidMapper;
import com.example.parcialweb.entity.LibroDavid;
import com.example.parcialweb.service.LibroDavidService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/libros")
public class LibroDavidController {

    private final LibroDavidService libroDavidService;

    @GetMapping("/list")
    public List<LibroDavidDTO> listarLibros() {
        return libroDavidService.getAllLibros().stream().map(LibroDavidMapper.MAPPER::libroToLibroDTO).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public LibroDavidDTO crearLibro(@RequestBody LibroDavid libroDavid) {
        return LibroDavidMapper.MAPPER.libroToLibroDTO(libroDavidService.saveLibro(libroDavid));
    }

    @PutMapping("/{id}")
    public LibroDavidDTO actualizarLibro(@PathVariable Long id, @RequestBody LibroDavid libro) {
        return LibroDavidMapper.MAPPER.
                libroToLibroDTO(libroDavidService.updateLibro(id, libro));
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroDavidService.deleteLibro(id);
    }
}
