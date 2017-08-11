create table usuarios (
	id integer primary key auto_increment not null,
    nome varchar(100) not null,
    email1 varchar(100) not null,
    email2 varchar(100) not null,
    telefone varchar(100) not null
);

INSERT INTO usuarios(nome, email1, email2, telefone) values('Lázaro Jr', 'lazaro@alura.com.br', 'lazaro@gmail.com', '41988990099');
INSERT INTO usuarios(nome, email1, email2, telefone) values('Caio Souza', 'caio@alura.com.br', 'caio@gmail.com', '11999880099');
INSERT INTO usuarios(nome, email1, email2, telefone) values('Alex Felipe', 'alex@alura.com.br', 'alex@gmail.com', '11988876677');
INSERT INTO usuarios(nome, email1, email2, telefone) values('Camila Castro', 'camila@alura.com.br', 'camila@gmail.com', '11988009900');
INSERT INTO usuarios(nome, email1, email2, telefone) values('Alberto Souza', 'alberto@alura.com.br', 'alberto@gmail.com', '11989890909');

select * from usuarios;

ALTER TABLE usuarios ADD COLUMN email3 varchar(100);
ALTER TABLE usuarios ADD COLUMN email4 varchar(100);
ALTER TABLE usuarios ADD COLUMN email5 varchar(100);

ALTER TABLE usuarios ADD COLUMN email_concatenado varchar(500);

create table emails (
     id integer primary key auto_increment not null,
     usuario_id int not null,
     email varchar(100) not null,
     is_primario boolean,
     FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

