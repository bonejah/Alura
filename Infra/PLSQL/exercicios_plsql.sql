-- Crie um usuário para o treinamento, utilizando a seguinte query:
CREATE USER cursoplsql IDENTIFIED BY cursoplsql DEFAULT tablespace users;

-- Conceda privilégios para o usuário criado para que possamos realizar as práticas do treinamento.
GRANT connect, resource TO cursoplsql;

-- Criando tabela SegMercado
CREATE TABLE SegMercado(
  ID NUMBER(5),
  Descricao VARCHAR2(100));

select * from SEGMERCADO;
DESC SEGMERCADO;

-- Para restringir valores iguais ou nulos no ID (regra de integridade):
ALTER TABLE SEGMERCADO add CONSTRAINT SEGMERCADO_ID_PK PRIMARY KEY (ID);

-- Criando a tabela Cliente
CREATE TABLE Cliente(
  ID NUMBER(5),
  Razao_Social VARCHAR2(100),
  CNPJ VARCHAR2(20),
  SegMercado_id NUMBER(5),
  Data_Inclusao DATE,
  Faturamento_Previsto NUMBER(10,2),
  Categoria VARCHAR2(20));

select * from Cliente;
DESC Cliente;

-- Para restringir valores iguais ou nulos no ID (regra de integridade):
ALTER TABLE Cliente add CONSTRAINT CLIENTE_ID_PK PRIMARY KEY (ID);

-- Adicione a chave estrangeira, para isso, execute a query:
ALTER TABLE Cliente ADD CONSTRAINT Cliente_SegMercado_fk FOREIGN KEY(SegMercado_id) REFERENCES Segmercado(id);


-- declarando variaveis e exibindo o valos
DECLARE
    v_a number(5) := 10;
    v_b number(5);
    v_c number(5);
BEGIN
    v_b := 15;
    v_c := v_a + v_b;
    DBMS_OUTPUT.PUT_LINE(v_c);
END;

-- Para obtermos uma saída, temos que setar a variável de ambiente para ON, para isso, adicione uma linha no topo do nosso código:
SET SERVEROUTPUT ON
DECLARE
    v_a number(5) := 1;
    v_b number(5);
    v_c number(5);
BEGIN
    v_b := 15;
    v_c := v_a + v_b;
    DBMS_OUTPUT.PUT_LINE((v_c));
END;

-- Inserindo dados na SegMercado
DECLARE
  v_id number(5) := 1;
  v_descricao VARCHAR2(100) := 'Varejo';
BEGIN 
  insert into segmercado values(v_id, v_descricao);
  commit;
END;

select * from segmercado;

-- para que a definição do tipo da variável seja sempre compatível com a definição da coluna no banco
DECLARE
  v_id segmercado.id%type := 2;
  v_descricao segmercado.descricao%type := 'Atacado';
BEGIN 
  insert into segmercado values(v_id, v_descricao);
  commit;
END;

select * from segmercado;

-- Gravando dados com Uppercase na Tabela
DECLARE
  v_id segmercado.id%type := 3;
  v_descricao segmercado.descricao%type := 'Lojista';
BEGIN 
  insert into segmercado values(v_id, upper(v_descricao));
  commit;
END;

select * from segmercado;

-- Atualizando a SegMercado
DECLARE
    v_id segmercado.id%type := 1;
    v_descricao segmercado.descricao%type := 'varejista';
BEGIN
    UPDATE segmercado SET descricao = UPPER(v_descricao) WHERE id = v_id;

    v_id := 3;
    v_descricao := 'lojista';

    UPDATE segmercado SET descricao = UPPER(v_descricao) WHERE id = v_id;
    COMMIT;
END;

-- Deletando o registro 3 (Lojista)
DECLARE
    v_id segmercado.id%type := 3;
BEGIN
    DELETE FROM segmercado 
         WHERE id = v_id;
    COMMIT;
END;

-- criando procedure para inserir na segmercado
create procedure incluir_segmercado(p_id in number, p_descricao in varchar2)
is
begin
  insert into segmercado values (p_id, UPPER(p_descricao));
  commit;
end;

-- executando a procedure
EXECUTE INCLUIR_SEGMERCADO(3, 'farmaceutico');
select * from segmercado;

-- Modificando o código para que a definição do tipo da variável seja sempre compatível com a definição da coluna no banco
CREATE OR REPLACE PROCEDURE incluir_segmercado (p_id IN segmercado.id%type, p_descricao IN segmercado.descricao%type)
IS
BEGIN
    INSERT into segmercado values(p_id, UPPER(p_descricao));
    COMMIT;
END;

-- Criando uma função para retornar a descricao do segmento de mercado
create or replace Function obter_descricao_segmercado
(p_id in segmercado.id%type)
return segmercado.descricao%type
is
  v_descricao segmercado.descricao%type;
begin
  select descricao
  into v_descricao
  from segmercado
  where id = p_id;
  
  return v_descricao;
end;

-- executando a função obter_descricao_sermercado
variable g_descricao varchar2(100);
execute :g_descricao := obter_descricao_segmercado(1);
print g_descricao;

-- chando a funcao dentro de um bloco PLSQL
set SERVEROUTPUT ON -- Utilizado para printar o resultado
declare
  v_descricao segmercado.descricao%type;
begin
  v_descricao := obter_descricao_segmercado(1);
  SYS.DBMS_OUTPUT.PUT_LINE('Descricao: ' || v_descricao);
end;


-- procedure para inserir clientes
create or replace procedure incluir_cliente(
  p_id in cliente.id%type, 
  p_razao_social in cliente.razao_social%type,
  p_cnpj in cliente.cnpj%type,
  p_segmercado_id in cliente.segmercado_id%type,
  p_faturamento_previsto in cliente.faturamento_previsto%type)
is
  v_categoria cliente.categoria%type;
begin
  v_categoria := categoria_cliente(p_faturamento_previsto);
  insert into cliente values (p_id, UPPER(p_razao_social), p_cnpj, p_segmercado_id, sysdate, p_faturamento_previsto, v_categoria);
  commit;
end;

-- executando a procedure para inserir cliente
execute incluir_cliente(4, 'CRUZEIRO', '9999', 1, 1000);
select * from cliente;

-- isolando em função a categoria do cliente
create or replace function categoria_cliente(
  p_faturamento_previsto in cliente.faturamento_previsto%type)
  return cliente.categoria%type
is
begin
  if p_faturamento_previsto < 10000 then
    return 'PEQUENO';
  elsif p_faturamento_previsto < 50000 then
    return 'MÉDIO';
  elsif p_faturamento_previsto < 100000 then
    return 'MÉDIO GRANDE';
  else
    return 'GRANDE';
  end if;
end;

-- 


