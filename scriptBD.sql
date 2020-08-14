create database if not exists projeto;
use projeto;

CREATE TABLE itmn032_usuario (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(100) NOT NULL,
  linkfoto varchar(200) DEFAULT NULL,
  nome varchar(100) NOT NULL,
  racf varchar(7) NOT NULL,
  senha varchar(30) DEFAULT NULL,
  constraint pk_usuario PRIMARY KEY (id),
  constraint UNIQUE KEY UK_email_usuario (email),
  constraint UNIQUE KEY UK_racf_usuario (racf)
);
 
create table itmn032_agencia(
   id integer not null auto_increment,
   nome_agencia varchar(100),
   hora_inicio  integer,
   hora_fim     integer,
   constraint pk_agencia primary key (id)
);

create table itmn032_agendamento(
   num_seq integer not null auto_increment,
   nome_cli  varchar(100),
   email_cli varchar(100),
   celular_cli varchar(20),
   data_agendamento date,
   hora_agendamento time,
   observacao varchar(255),
   id_agencia integer not null,
   constraint pk_agendamento primary key (num_seq),
   constraint fk_agencia foreign key (id_agencia) references itmn032_agencia(id)
);