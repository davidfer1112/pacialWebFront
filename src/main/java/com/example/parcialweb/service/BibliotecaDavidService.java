package com.example.parcialweb.service;

import com.example.parcialweb.dto.BibliotecaDavidDTO;
import com.example.parcialweb.entity.BibliotecaDavid;
import com.example.parcialweb.repository.BibliotecaDavidRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BibliotecaDavidService {

    private final BibliotecaDavidRepository bibliotecaDavidRepository;

    public List<BibliotecaDavid> getAllBibliotecas() {
        return bibliotecaDavidRepository.findAll();
    }

    public Optional<BibliotecaDavid> getBibliotecaById(long id) {
        return bibliotecaDavidRepository.findById(id);
    }

    public BibliotecaDavid saveBiblioteca(BibliotecaDavid biblioteca) {
        return bibliotecaDavidRepository.save(biblioteca);
    }

    public BibliotecaDavid updateBiblioteca(Long id, BibliotecaDavid biblioteca) {
        if (bibliotecaDavidRepository.existsById(id)) {
            BibliotecaDavid nuevo = bibliotecaDavidRepository.findById(id).orElse(null);
            nuevo.setNombre(biblioteca.getNombre());
            nuevo.setCiudad(biblioteca.getCiudad());
            nuevo.setDireccion(biblioteca.getDireccion());
            return bibliotecaDavidRepository.save(nuevo);
        }
        return null;
    }

    public void deleteBiblioteca(Long id) {
        bibliotecaDavidRepository.deleteById(id);
    }
}
