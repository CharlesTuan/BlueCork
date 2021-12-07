package br.univille.bluecork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.bluecork.model.Cliente;

@Service
public interface PacienteService {
    void save(Cliente cliente);
    List<Cliente> getAll();
    void delete(Cliente cliente);
    List<Cliente> getAllByNome(String nome);
}