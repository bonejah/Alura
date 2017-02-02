CREATE DATABASE fj21;

CREATE TABLE tarefa (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dataFinalizacao date DEFAULT NULL,
  descricao varchar(255) NOT NULL,
  finalizado bit(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE usuarios (
  usuario varchar(255) DEFAULT NULL,
  senha varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;