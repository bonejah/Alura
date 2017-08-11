desc autores;

select * from autores;

create index indice_nome on autores(nome);
show index from autores;

select distinct nome from autores;

alter table autores drop index indice_nome;