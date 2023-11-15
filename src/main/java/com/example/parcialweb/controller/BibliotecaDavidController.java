package com.example.parcialweb.controller;

import com.example.parcialweb.dto.BibliotecaDavidDTO;
import com.example.parcialweb.dto.BibliotecaDavidMapper;
import com.example.parcialweb.entity.BibliotecaDavid;
import com.example.parcialweb.service.BibliotecaDavidService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/bibliotecas")
public class BibliotecaDavidController {

    private final BibliotecaDavidService bibliotecaDavidService;

    @GetMapping("/list")
    public List<BibliotecaDavidDTO> listarBiblioteca() {
        return bibliotecaDavidService.getAllBibliotecas().stream().map(BibliotecaDavidMapper.MAPPER::bibliotecaToBibliotecaDTO).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public BibliotecaDavidDTO crearBiblioteca(@RequestBody BibliotecaDavid bibliotecaDavid) {
        return BibliotecaDavidMapper.MAPPER.bibliotecaToBibliotecaDTO(bibliotecaDavidService.saveBiblioteca(bibliotecaDavid));
    }

    @PutMapping("/{id}")
    public BibliotecaDavidDTO actualizarBibliotecas(@PathVariable Long id, @RequestBody BibliotecaDavid biblioteca) {
        return BibliotecaDavidMapper.MAPPER.
                bibliotecaToBibliotecaDTO(bibliotecaDavidService.updateBiblioteca(id, biblioteca));
    }

    @DeleteMapping("/{id}")
    public void eliminarBiblioteca(@PathVariable Long id) {
        bibliotecaDavidService.deleteBiblioteca(id);
    }




}