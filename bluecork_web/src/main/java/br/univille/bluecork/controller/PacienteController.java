package br.univille.bluecork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.bluecork.model.Cliente;
import br.univille.bluecork.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public ModelAndView index(@RequestParam(required = false) String busca){

        List<Cliente> listaPacientes = null;
        if(busca == null){
            listaPacientes = service.getAll();
        }else{
            listaPacientes = service.getAllByNome(busca);
        }
        
        return new ModelAndView("paciente/index","listapacientes",listaPacientes);
    }

    @GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Cliente cliente) {
		return new ModelAndView("paciente/form");
	}

    @PostMapping(params="form")
    public ModelAndView save(Cliente cliente){
        service.save(cliente);
        return new ModelAndView("redirect:/paciente");
    }

    @GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Cliente cliente) {
		return new ModelAndView("paciente/form","paciente",cliente);
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Cliente cliente){
        service.delete(cliente);
        return new ModelAndView("redirect:/paciente");
    }


}