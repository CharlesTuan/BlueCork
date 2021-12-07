package br.univille.bluecork.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.bluecork.model.Cliente;
import br.univille.bluecork.service.PacienteService;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteControllerAPI {
    @Autowired
    private PacienteService service;

    
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        List<Cliente> lista = service.getAll();
        return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Cliente cliente){
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        service.save(cliente);
        //return ResponseEntity.ok().build();
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Cliente pacienteAntigo, 
                                            @RequestBody Cliente pacienteAtualizado){
        pacienteAntigo.setNome(pacienteAtualizado.getNome());
        pacienteAntigo.setSexo(pacienteAtualizado.getSexo());
        pacienteAntigo.setDataNascimento(pacienteAtualizado.getDataNascimento());

        service.save(pacienteAntigo);
        return new ResponseEntity<Cliente>(pacienteAntigo,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Cliente cliente){
        if(cliente == null){
            return ResponseEntity.notFound().build();    
        }
        service.delete(cliente);
        return ResponseEntity.ok().build();
    }


}