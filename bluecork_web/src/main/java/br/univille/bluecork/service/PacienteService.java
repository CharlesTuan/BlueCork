package br.univille.bluecork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.bluecork.model.Paciente;

@Service
public interface PacienteService {
    void save(Paciente paciente);
    List<Paciente> getAll();
    void delete(Paciente paciente);
    List<Paciente> getAllByNome(String nome);
}