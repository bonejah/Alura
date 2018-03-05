# Course Oracle

* Commands Oracle
```
https://s3.amazonaws.com/caelum-online-public/oracle-sql/sql/cap1us.sql
SQL> @DIRETORIO_DO_ARQUIVO_SQL/cap1.sql
SQL> @/home/alura/Downloads/cap1.sql

GRANT DBA TO nome-do-usuario;
To verify language pattern Oracle: show parameter nls_lang;
To access oracle: sqlplus

To create a table:
create table compras (
    id number primary key,
    valor number,
    data date,
    observacoes varchar2(30),
    recebido char check (recebido in (0,1))
);
create sequence id_seq;

To insert in a table:
INSERT INTO COMPRAS (ID, VALOR, DATA, OBSERVACOES, RECEBIDO) VALUES (ID_SEQ.NEXTVAL, 100.0, '12-JUN-2007', 'COMPRAS DE JUNHO', '1');

To select data:
SELECT * FROM COMPRAS;
SELECT VALOR, DATA FROM COMPRAS;
SELECT VALOR*0.20 FROM COMPRAS;
SELECT VALOR, VALOR *0.20 AS IMPOSTOS FROM COMPRAS;
SELECT * FROM COMPRAS WHERE VALOR > 1000;
SELECT * FROM COMPRAS WHERE (DATA > '01-JAN-2010' AND DATA < '01-JUL-2010') or (DATA > '01-JAN-2012' AND DATA < '01-JUL-2012');
SELECT * FROM COMPRAS WHERE VALOR >= 1000;
SELECT * FROM COMPRAS WHERE VALOR <= 1000;
SELECT * FROM COMPRAS WHERE VALOR <> 1000;
SELECT * FROM COMPRAS WHERE OBSERVACOES = 'COMPRAS DE JANEIRO';
SELECT * FROM COMPRAS WHERE OBSERVACOES LIKE 'COMPRAS%';
SELECT * FROM COMPRAS WHERE OBSERVACOES LIKE '%COMPRAS%';

```