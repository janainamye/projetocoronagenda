package br.gama.projagenda.dao;

import org.springframework.data.repository.CrudRepository;

import br.gama.projagenda.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    public Usuario findByEmailOrRacf(String email, String racf);
}