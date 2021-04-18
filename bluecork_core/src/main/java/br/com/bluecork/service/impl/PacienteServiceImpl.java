package br.com.bluecork.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluecork.model.Paciente;
import br.com.bluecork.repository.PacienteRepository;
import br.com.bluecork.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repository;
    
    @Override
    public void save(Paciente paciente) {
        repository.save(paciente);
    }

    @Override
    public List<Paciente> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Paciente paciente) {
        repository.delete(paciente);
    }    
}