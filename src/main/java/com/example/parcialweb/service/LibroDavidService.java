package com.example.parcialweb.service;

import com.example.parcialweb.entity.BibliotecaDavid;
import com.example.parcialweb.entity.LibroDavid;
import com.example.parcialweb.repository.LibroDavidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroDavidService {

    private final LibroDavidRepository libroDavidRepository;

    @Autowired
    public LibroDavidService(LibroDavidRepository libroDavidRepository) {
        this.libroDavidRepository = libroDavidRepository;
    }

    public List<LibroDavid> getAllLibros() {
        return libroDavidRepository.findAll();
    }

    public Optional<LibroDavid> getLibroById(long id) {
        return libroDavidRepository.findById(id);
    }

    public LibroDavid saveLibro(LibroDavid libro) {
        return libroDavidRepository.save(libro);
    }

    public LibroDavid updateLibro(Long id, LibroDavid libro) {
        if (libroDavidRepository.existsById(id)) {
            LibroDavid nuevo = libroDavidRepository.findById(id).orElse(null);
            nuevo.setNombre(libro.getNombre());
            nuevo.setAutor(libro.getAutor());
            return libroDavidRepository.save(nuevo);
        }
        return null;
    }

    public void deleteLibro(Long id) {
        libroDavidRepository.deleteById(id);
    }
}
