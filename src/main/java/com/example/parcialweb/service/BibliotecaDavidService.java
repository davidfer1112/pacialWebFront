package com.example.parcialweb.service;

import com.example.parcialweb.entity.BibliotecaDavid;
import com.example.parcialweb.repository.BibliotecaDavidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaDavidService {

    private final BibliotecaDavidRepository bibliotecaDavidRepository;

    @Autowired
    public BibliotecaDavidService(BibliotecaDavidRepository bibliotecaDavidRepository) {
        this.bibliotecaDavidRepository = bibliotecaDavidRepository;
    }

    public List<BibliotecaDavid> getAllBibliotecas() {
        return bibliotecaDavidRepository.findAll();
    }

    public Optional<BibliotecaDavid> getBibliotecaById(long id) {
        return bibliotecaDavidRepository.findById(id);
    }

    public BibliotecaDavid saveBiblioteca(BibliotecaDavid biblioteca) {
        return bibliotecaDavidRepository.save(biblioteca);
    }

    public void deleteBiblioteca(long id) {
        bibliotecaDavidRepository.deleteById(id);
    }
}
