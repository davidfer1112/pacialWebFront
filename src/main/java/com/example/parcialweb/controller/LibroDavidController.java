package com.example.parcialweb.controller;

import com.example.parcialweb.dto.LibroDavidDTO;
import com.example.parcialweb.entity.LibroDavid;
import com.example.parcialweb.service.LibroDavidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/libros")
public class LibroDavidController {

    private final LibroDavidService libroDavidService;

    @Autowired
    public LibroDavidController(LibroDavidService libroDavidService) {
        this.libroDavidService = libroDavidService;
    }

    @GetMapping
    public List<LibroDavidDTO> getAllLibros() {
        List<LibroDavid> libros = libroDavidService.getAllLibros();
        return libros.stream()
                .map(LibroDavidDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDavidDTO> getLibroById(@PathVariable long id) {
        Optional<LibroDavid> libroDavidOptional = libroDavidService.getLibroById(id);
        return libroDavidOptional.map(libroDavid ->
                        ResponseEntity.ok(LibroDavidDTO.fromEntity(libroDavid)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LibroDavidDTO> saveLibro(@RequestBody LibroDavidDTO libroDTO) {
        LibroDavid libro = LibroDavidDTO.toEntity(libroDTO);
        libro = libroDavidService.saveLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(LibroDavidDTO.fromEntity(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable long id) {
        boolean exists = libroDavidService.getLibroById(id).isPresent();
        if (exists) {
            libroDavidService.deleteLibro(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
