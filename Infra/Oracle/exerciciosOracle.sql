-- Curso Oracle I Alura 
-- Verifica a linguagem utilizada pelo oracle
show parameter nls_lang;

-- Criando tabela Compras
create table COMPRAS (
id number primary key,
valor number,
data date,
observacoes varchar2(30),
recebido char check(recebido in (0,1)));

-- Criando a sequence
create sequence id_seq;

-- Seleciona todas as compras
select * from compras;

-- Selecione VALOR e OBSERVA��ES de todas as compras cuja data seja maior ou igual que 15/11/2008. 
select valor, observacoes from compras where DATA >= '15-NOV-2008';

-- Selecione todas as compras cuja data seja maior ou igual que 15/11/2008 e menor do que 15/11/2010
select * from compras where DATA >= '15-NOV-2008' and DATA < '15-NOV-2010';

-- Selecione todas as compras cujo valor esteja entre R$15,00 e R$35,00 e a observa��o comece com a palavra 'LANCHONETE'.
select * from compras where valor >= 15.0 and valor <= 35.0 and observacoes like 'LANCHONETE%';

-- Selecione todas as compras que j� foram recebidas
select * from compras where RECEBIDO = '1';

-- Selecione todas as compras que ainda n�o foram recebidas
select * from compras where RECEBIDO = '0';

-- Selecione todas as compras com valor maior que 5.000,00 ou que j� foram recebidas. 
select * from compras where valor > 5000 or RECEBIDO = '1';

-- Selecione todas as compras que o valor esteja entre 1.000,00 e 3.000,00 ou seja maior que 5.000,00
select * from compras where (valor >= 1000 and valor <= 3000) or (valor > 5000);

-- Altere as compras, colocando a observa��o 'compras do dia dos namorados' para todas as que foram efetuadas no dia 12/06/2010.
update compras set observacoes = 'compras do dia dos namorados' where DATA = '12-JUN-2010';

-- Altere o VALOR das compras feitas antes de 01/06/2009. Some R$10,00 ao valor atual.
update compras set valor = valor + 10 where data < '01-JUN-2009';

-- Atualize todas as compras feitas entre 01/07/2009 e 01/07/2010 para que elas tenham a observa��o 
-- 'entregue antes de 2011' e a coluna recebido com o valor '1' (TRUE).
select * from compras where data between '01-JUL-2009' and '01-JUL-2010';
update compras set OBSERVACOES = 'entregue antes de 2011', RECEBIDO = '1' where data between '01-JUL-2009' and '01-JUL-2010';

-- Exclua as compras realizadas entre 05 e 20 mar�o de 2009
select * from compras where data BETWEEN '05-MAR-2009' and '20-05-2009';
delete from compras where data BETWEEN '05-MAR-2009' and '20-05-2009';

-- Use o operador NOT e monte um SELECT que retorna todas as compras com valor diferente de R$ 108,00.
select * from compras where valor <> 108;
select * from compras where valor not in (108);
select * from compras where not valor = 108;

-- Comando para descrever a tabela compras 
desc compras;

-- Inserindo null no campo observacoes
INSERT INTO compras (ID, VALOR, DATA, OBSERVACOES, FORMA_PAGT) VALUES (ID_SEQ.NEXTVAL, 700.0, '05-MAR-2018', 'compra de mar�o', 'boleto');
select * from compras;

-- Deletando o registro com observacao null
delete  from compras where observacoes is null;
select * from compras;

-- Evitando a inser��o de nulos na tabela
alter table compras modify (observacoes varchar2(30) not null);

-- Atribuindo um valor padr�o para uma coluna espec�fica
alter table compras modify (recebido char DEFAULT '0' check (recebido in(0,1))); 

-- Adicionando novas colunas � tabela
alter table compras add(forma_pagt varchar2(15) check(forma_pagt in('boleto', 'cartao', 'dinheiro')));

-- Renomeando a coluna criada
alter table compras RENAME COLUMN forma_pagt to forma_pagto;

select * from compras where FORMA_PAGTO is null;
update compras set FORMA_PAGTO = 'dinheiro' where FORMA_PAGTO is null;

-- Exibindo a soma dos valores de todas as compras
select sum(valor) from compras;
select sum(valor) from compras where data < '01-JAN-2010';

-- M�dia dos valores das compras,
select avg(valor) from compras;
select avg(valor), sum(valor) from compras;

-- Contagem das compras
select count(valor) from compras where data < '01-JAN-2010';

-- Soma de todas as compras recebidas e n�o recebidas
select sum(valor) from compras where RECEBIDO = '1';
select sum(valor) from compras where RECEBIDO = '0';
select recebido, sum(valor) as soma, count(valor) as from compras group by RECEBIDO order by soma desc;

-- Calcule a m�dia dos valores de todas as compras com datas inferiores a 12/03/2009
select avg(valor) as media from compras where data < '12-MAR-2009';

-- Calcule a soma dos valores de todas as compras com datas inferiores a 10/11/2010, agrupadas por forma de pagamento
select FORMA_PAGTO, sum(valor) soma from compras where data < '10-NOV-2010' group by FORMA_PAGTO;

-- Calcule a quantidade de compras com datas inferiores a 12/03/2009 e que j� foram recebidas.
select count(1) as quantidade from compras where data < '12-MAR-2009' and RECEBIDO = '1';

-- Calcule a soma dos valores de todas as compras, agrupadas por forma de pagamento e por compra recebida ou n�o
select forma_pagto, recebido, sum(valor) soma from compras group by forma_pagto, recebido;

-- Criando a tabela compradores
CREATE TABLE COMPRADORES (
    ID NUMBER PRIMARY KEY,
    NOME VARCHAR2(30) NOT NULL,
    ENDERECO VARCHAR2(30) NOT NULL,
    TELEFONE VARCHAR2(20) NOT NULL
);

CREATE SEQUENCE ID_COMPRADORES_SEQ;

desc COMPRADORES;

-- Inseridndo na tabela compradores
INSERT INTO COMPRADORES (ID, NOME, ENDERECO, TELEFONE) VALUES (ID_COMPRADORES_SEQ.NEXTVAL, 'FLAVIO', 'RUA DO OUVIDOR, 123', '(21) 1111-1111');
INSERT INTO COMPRADORES (ID, NOME, ENDERECO, TELEFONE) VALUES (ID_COMPRADORES_SEQ.NEXTVAL, 'NICO', 'AV. PRESIDENTE VARGAS, 123', '(21) 2222-2222');
select * from COMPRADORES; 

-- Referenciando a compra ao seu comprador (um-pra-muitos, ou one-to-many)
alter table compras add (COMPRADOR_ID NUMBER);

-- Atualizando a tabela compras
UPDATE COMPRAS SET COMPRADOR_ID = 1 WHERE ID < 8;
UPDATE COMPRAS SET COMPRADOR_ID = 2 WHERE ID >= 8;
select * from compras;

-- Modificando COMPRADOR_ID para n�o aceitar null)
ALTER TABLE COMPRAS MODIFY (COMPRADOR_ID NUMBER NOT NULL);
DESC COMPRAS;

-- Juntando duas tabelas diferentes
select * from compras join compradores on compras.comprador_id = compradores.id;
select * FROM compras inner join compradores on compras.comprador_id = compradores.id;

-- Alterando a coluna comprador_id para FK
alter table COMPRAS add foreign key (COMPRADOR_ID) references COMPRADORES(ID);

-- Exiba o NOME do comprador e o VALOR de todas as compras feitas antes de 09/07/2010
select nome, valor from compras join compradores on compras.COMPRADOR_ID = compradores.ID where data < '09-JUL-2010';

-- Exiba todas as compras do comprador que possui ID igual a 1.
select * from compras where compras.COMPRADOR_ID = 1;
select * from compras join compradores on compras.COMPRADOR_ID = compradores.ID where compras.COMPRADOR_ID = 1;

-- Exiba todas as compras (mas sem os dados do comprador), cujo comprador tenha nome que comece com 'FLAVIO'.
select compras.* from compras join COMPRADORES on compras.COMPRADOR_ID = COMPRADORES.ID where COMPRADORES.NOME like 'FLAVIO%';

-- Exiba o nome do comprador e a soma de todas as suas compras.
select compradores.nome, sum(compras.valor) as soma
from compras join compradores  on compras.COMPRADOR_ID = compradores.id 
group by compradores.nome;

select sum(valor) from compras;

-- -----------------------------------------------------------------------------
-- Curso Oracle II Alura 

-- Comando para aumentar os caracteres do console oracle
set linesize 200;

-- Comando para verificar a linguagem padr�o do Oracle
show parameter nls_lang;

-- Comando para selecionar todas as tabelas do usu�rio
select table_name  from user_tables order by 1;

-- Consultando os alunos
select nome from aluno;

-- Verificando as matriculas dos alunos
select nome from aluno join matricula on matricula.aluno_id = aluno.id;

-- Verificando o aluno e o nome do curso
select aluno.nome, curso.nome 
from aluno 
join matricula on matricula.aluno_id = aluno.id
join curso on curso.ID = matricula.CURSO_ID;

select a.nome, c.nome 
from aluno a
join matricula m on m.aluno_id = a.id
join curso c on c.ID = m.CURSO_ID;

-- Exibindo alunos com matr�cula
select a.nome from aluno a;
select a.nome from aluno a where exists (
  select m.id from matricula m where m.ALUNO_ID = a.ID
);

-- Exibindo alunos sem matr�cula
select a.nome from aluno a where not exists (
  select m.id from matricula m where m.ALUNO_ID = a.ID
);

-- Existem exerc�cios n�o respondidos
select * from exercicio;
select * from exercicio e where exists (
  select r.id from resposta r where r.EXERCICIO_ID = e.ID
);

select * from exercicio e where not exists (
  select r.id from resposta r where r.EXERCICIO_ID = e.ID
);

-- Quais cursos est�o com  matr�cula?
select c.nome from curso c where exists (
  select m.id from matricula m where m.CURSO_ID = c.ID
);

-- Quais cursos est�o sem  matr�cula?
select c.nome from curso c where not exists (
  select m.id from matricula m where m.CURSO_ID = c.ID
);

-- Busque todos os alunos que n�o tiveram nenhuma matr�cula no �ltimo ano, usando a instru��o EXISTS
select a.nome from aluno a where not exists (
    select m.id from matricula m where m.aluno_id = a.id and 
    m.data > (select sysdate - interval '1' year from dual));
    
select a.nome from aluno a where (
    select count(m.id) from matricula m where m.aluno_id = a.id and 
    m.data > (select sysdate - interval '1' year from dual)) = 0;   
    
-- M�dias das notas por curso
desc nota;
desc resposta;
desc exercicio;
desc secao;
desc curso;

select c.nome, avg(n.nota) as media from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
group by c.nome;

-- Quantidade de exerc�cios por curso
select c.nome, count(e.id) as qtde_exercicios from exercicio e
join secao s on s.id = e.SECAO_ID
join curso c on c.id = s.CURSO_ID
group by c.nome;
    
-- Quantos alunos temos matriculados em cada curso?
select c.nome, count(a.id) as qtde_alunos from curso c
join matricula m on m.CURSO_ID = c.ID
join aluno a on a.ID = m.ALUNO_ID
group by c.nome;

select c.nome, count(a.id) from aluno a
join matricula m on m.ALUNO_ID = a.ID
join curso c on c.ID = m.CURSO_ID
group by c.nome;

-- Selecione o curso e as m�dias de notas, levando em conta somente alunos que tenham "Silva" ou "Santos" no sobrenome.
select c.nome, avg(n.id) as media_notas from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.ID = r.ALUNO_ID
where (a.nome like '%Silva' or a.NOME like '%Santos')
group by c.nome;

-- Conte a quantidade de respostas por exerc�cio. Exiba a pergunta e o n�mero de respostas.
desc resposta;
desc exercicio;

select e.pergunta, count(r.id) as quantidade from resposta r
join exercicio e on e.id = r.exercicio_id
group by e.pergunta;

select e.pergunta, count(r.id) as quantidade from resposta r
join exercicio e on e.id = r.exercicio_id
group by e.pergunta order by count(r.id) desc;

-- A m�dia de notas por aluno por curso
select a.nome, c.nome, avg(n.nota) as media from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.ID = r.ALUNO_ID
group by a.nome,  c.nome;

-- HAVING � utilizado para filtrar o resultado de um agrupamento, resultado de 
-- uma fun��o agregada por exemplo, enquanto o WHERE � usado quando queremos 
-- filtrar as linhas antes do agrupamento.

-- Selecionando a m�dia das notas de um aluno aprovado
select a.nome as nome_aluno, c.nome as nome_curso, avg(n.nota) from nota n
join resposta r on r.ID = n.RESPOSTA_ID
join exercicio e on e.ID = r.EXERCICIO_ID
join secao s on s.ID = e.SECAO_ID
join curso c on c.ID = s.CURSO_ID
join aluno a on a.id = r.aluno_id
group by a.nome, c.nome
having avg(n.nota) > 5;
-- having avg(n.nota) < 5; -- alunos reprovados;

-- Quantos alunos temos matriculados em cada curso?
select count(a.id) as quantidade, c.nome as nome_curso, a.nome as nome_aluno from curso c
    join matricula m on m.curso_id = c.id
    join aluno a on m.aluno_id = a.id
group by c.nome, a.nome
having count(a.id) < 3
order by nome_curso;

-- Exiba todos os cursos e a sua quantidade de matr�culas. Mas exiba somente cursos que tenham mais de 1 matr�cula.
select c.nome, count(m.id) as quantidade from curso c
join matricula m on m.CURSO_ID = c.ID
group by c.nome
having count(m.id) < 1;

-- Exiba o nome do curso e a quantidade de se��es que existe nele. Mostre s� cursos com mais de 3 se��es.
select c.nome, count(s.id) as quantidade_secoes from curso c
join secao s on s.CURSO_ID = c.ID
group by c.nome
having count(s.id) > 3;




