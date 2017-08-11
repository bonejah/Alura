select  * from livros where data_de_lancamento = '2015-03-19' ;

explain select *, 
     (select count(l2.data_de_lancamento) from livros l2 where l2.data_de_lancamento = l.data_de_lancamento) as anteriores
from livros l order by l.data_de_lancamento;

create index indice_por_lancamento on livros(data_de_lancamento);

desc livros;
show index from livros

