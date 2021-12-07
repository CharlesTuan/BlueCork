package br.univille.bluecork.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.bluecork.model.Cliente;

@Repository
public interface PacienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findAllByDataNascimento(Date dataNascimento);
    List<Cliente> findAllByNomeContainsIgnoreCase(String nome);
}