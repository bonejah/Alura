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
  e_null exception;
  pragma exception_init (e_null, -1400);
begin
  v_categoria := categoria_cliente(p_faturamento_previsto);
  insert into cliente values (p_id, UPPER(p_razao_social), p_cnpj, p_segmercado_id, sysdate, p_faturamento_previsto, v_categoria);
  commit;
  
  EXCEPTION
    WHEN dup_val_on_index then
        --dbms_output.put_line ('Cliente já cadastrado');
      raise_application_error(-20010,'Cliente já cadastrado');
    WHEN e_null then
      raise_application_error(-20015,'A coluna ID tem preenchimento obrigatório');
    WHEN others then
      raise_application_error(-20020,sqlerrm());
end;

-- executando a procedure para inserir cliente
execute incluir_cliente(5, 'FASS', '987654321', 1, 1000);
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

-- Formatando o CNPJ
CREATE OR REPLACE PROCEDURE FORMAT_CNPJ
    (p_cnpj IN OUT cliente.CNPJ%type)
IS
BEGIN
    p_cnpj := substr(p_cnpj,1,2) || '/' || substr(p_cnpj,3);
END;

VARIABLE g_cnpj varchar2(10);
execute :g_cnpj := '123456789';
print g_cnpj;

execute FORMAT_CNPJ(:g_cnpj);
print g_cnpj;

-- Criando a procedure ATUALIZAR_CLI_SEG_MERCADO
CREATE OR REPLACE PROCEDURE ATUALIZAR_CLI_SEG_MERCADO
    (p_id IN cliente.id%type,
     p_segmercado_id IN cliente.segmercado_id%type)
IS
    e_cliente_id_inexistente exception;
BEGIN
    UPDATE cliente
        SET segmercado_id = p_segmercado_id
        WHERE id = p_id;
    IF SQL%NOTFOUND then
        RAISE e_cliente_id_inexistente;
    END IF;
    COMMIT;
EXCEPTION
    WHEN e_cliente_id_inexistente then
        raise_application_error(-20100,'Cliente inexistente');
END;

-- Atualizando os segmentos de mercado - FORMA 1
DECLARE
    v_segmercado_id cliente.segmercado_id%type := 3;
    v_i number(5);
BEGIN
    v_i := 1;
LOOP
    ATUALIZAR_CLI_SEG_MERCADO(v_i, v_segmercado_id);
    v_i := v_i +1;
    EXIT WHEN v_i > 5;
 END LOOP;
END;

select * from cliente;

-- Atualizando os segmentos de mercado - FORMA 2
DECLARE
    v_segmercado_id cliente.segmercado_id%type := 2;
BEGIN
    FOR i in 1..3 LOOP
        ATUALIZAR_CLI_SEG_MERCADO(i, v_segmercado_id);
    END LOOP;
     COMMIT;
END;

select * from cliente;

-- Utilizando CURSOR para percorrer a tabela Cliente
DECLARE
    v_segmercado_id cliente.segmercado_id%type := 1;
    v_id cliente.id%type;
    CURSOR cur_cliente is SELECT id from cliente; 
BEGIN
    FOR cli_rec IN cur_cliente LOOP
       ATUALIZAR_CLI_SEG_MERCADO(cli_rec.id, v_segmercado_id);
    END LOOP;
END;

select * from cliente;

-- Aprendendo sobre CURSOR
DECLARE
   v_id cliente.id%type;
   v_segmercado_id cliente.segmercado_id%type := 3;
   cursor cur_cliente is select id from cliente;
BEGIN
  open cur_cliente;
  loop  
    fetch cur_cliente into v_id;
    exit when cur_cliente%NOTFOUND;
      ATUALIZAR_CLI_SEG_MERCADO(v_id, v_segmercado_id);
  end loop;
  close cur_cliente;
END;
select * from cliente;

DECLARE
    v_segmercado_id cliente.segmercado_id%type := 2;
    CURSOR cur_cliente is SELECT id FROM cliente;
BEGIN
    FOR cli_rec IN cur_cliente LOOP
        ATUALIZAR_CLI_SEG_MERCADO(cli_rec.id, v_segmercado_id);
    END LOOP;
    COMMIT;
END;
select * from cliente;

-- Tratando exceções
SET SERVEROUTPUT ON
EXECUTE INCLUIR_CLIENTE(1,'SUPERMERCADO XYZ','12345',2,150000);
EXECUTE INCLUIR_CLIENTE(NULL,'SUPERMERCADO TYU','65712',2,150000)
