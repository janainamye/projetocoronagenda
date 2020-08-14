package br.gama.projagenda.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.projagenda.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
    public List<Agendamento> findByAgencia(int id); /* perguntar se é isso mesmo */
    public List<Agendamento> findByDataAgendamento(Date data);
    public List<Agendamento> findByNome(String nome);
   
}