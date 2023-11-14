package com.example.parcialweb.controller;

import com.example.parcialweb.dto.BibliotecaDavidDTO;
import com.example.parcialweb.entity.BibliotecaDavid;
import com.example.parcialweb.service.BibliotecaDavidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaDavidController {

    private final BibliotecaDavidService bibliotecaDavidService;

    @Autowired
    public BibliotecaDavidController(BibliotecaDavidService bibliotecaDavidService) {
        this.bibliotecaDavidService = bibliotecaDavidService;
    }

    @GetMapping
    public List<BibliotecaDavidDTO> getAllBibliotecas() {
        List<BibliotecaDavid> bibliotecas = bibliotecaDavidService.getAllBibliotecas();
        return bibliotecas.stream()
                .map(BibliotecaDavidDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaDavidDTO> getBibliotecaById(@PathVariable long id) {
        Optional<BibliotecaDavid> bibliotecaDavidOptional = bibliotecaDavidService.getBibliotecaById(id);
        return bibliotecaDavidOptional.map(bibliotecaDavid ->
                        ResponseEntity.ok(BibliotecaDavidDTO.fromEntity(bibliotecaDavid)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BibliotecaDavidDTO> saveBiblioteca(@RequestBody BibliotecaDavidDTO bibliotecaDTO) {
        BibliotecaDavid biblioteca = BibliotecaDavidDTO.toEntity(bibliotecaDTO);
        biblioteca = bibliotecaDavidService.saveBiblioteca(biblioteca);
        return ResponseEntity.status(HttpStatus.CREATED).body(BibliotecaDavidDTO.fromEntity(biblioteca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiblioteca(@PathVariable long id) {
        boolean exists = bibliotecaDavidService.getBibliotecaById(id).isPresent();
        if (exists) {
            bibliotecaDavidService.deleteBiblioteca(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}