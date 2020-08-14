package br.gama.projagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.gama.projagenda.dao.AgenciaDAO;
import br.gama.projagenda.model.Agencia;

@RestController
@CrossOrigin("*")
public class AgenciaController {
    
    @Autowired
    private AgenciaDAO dao;

    @GetMapping("/agencias")
    public List<Agencia> getAgencias(){
        List<Agencia> lista = (List<Agencia>)dao.findAll();
        return  lista;
    }

    @GetMapping("/agencia/{id}") 
    public Agencia getAgencia(@PathVariable int id){
        Agencia agencia = dao.findById(id).orElse(null);
        return  agencia;
    } 

}