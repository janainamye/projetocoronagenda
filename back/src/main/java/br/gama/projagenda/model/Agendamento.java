package br.gama.projagenda.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn032_agendamento")
public class Agendamento {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
    private int numSeq;
    
    @Column(name="nome_cli", length=100, nullable=false)
    private String nome;
    
    @Column(name="email_cli", length=100)
    private String email;
    
    @Column(name="celular_cli", length=20)
    private String celular;
    
    @Column(name="data_agendamento")
    private Date dataAgendamento;
    
    @Column(name="hora_agendamento")
    private Time horaAgendamento;
    
    @Column(name="observacao", length=255)
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "id_agencia")
    @JsonIgnoreProperties("agendamentos")
    private Agencia agencia;

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Time getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(Time horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

    
}