package br.univille.bluecork.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.bluecork.model.Cliente;
import br.univille.bluecork.repository.PacienteRepository;
import br.univille.bluecork.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Cliente cliente) {
        repository.delete(cliente);
    }

    @Override
    public List<Cliente> getAllByNome(String nome) {
        return repository.findAllByNomeContainsIgnoreCase(nome);
    }
    
}