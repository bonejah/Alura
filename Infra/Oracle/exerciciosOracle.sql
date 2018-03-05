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



