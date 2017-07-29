module.exports = function(app){
	var listaProdutos = function(req, res, next){	
		var connection = app.infra.connectionFactory();
		var produtosDAO = new app.infra.ProdutosDAO(connection);

		produtosDAO.lista(function(errors, results){
			console.log(errors);

			if(errors){
				return next(errors);
			}

			res.format({
				html: function(){
					res.render('produtos/lista',{lista:results});
				},

				json: function(){
					res.json(results);
				}
			});
			res.render('produtos/lista',{lista:results});
		});

		connection.end();
	};

	app.get('/produtos', listaProdutos);
	
	app.get('/produtos/form', function(req, res){
		res.render('produtos/form', {errosValidacao:{}, produto:{}});
	});

	// always redirect after post = ARAP
	//app.post('/produtos/salva', function(req, res){
	app.post('/produtos', function(req, res){
		var produto = req.body;
		console.log(produto);
		
		req.assert('titulo', 'Título é obrigatório').notEmpty();
		req.assert('preco', 'Formato inválido').isFloat();
		req.assert('descricao', 'Descrição é obrigatória').notEmpty();

		var errors = req.validationErrors();
		if(errors){
			res.format({
				html: function(){
					res.status(400).render('produtos/form',{errosValidacao:errors, produto:produto});
				},

				json: function(){
					res.status(400).json(errors);
				}
			});
			return;
		}
		
		var connection = app.infra.connectionFactory();
		var produtosDAO = new app.infra.ProdutosDAO(connection);

		produtosDAO.salva(produto, function(errors, results){
			console.log(errors);		
			res.redirect('/produtos');
		});

		connection.end();
	});

	app.get('produtos/remove', function(){
		var connection = app.infra.connectionFactory();
		var produtosDAO = new app.infra.ProdutosDAO(connection);		
		var produto = produtosDAO.carrega(id, callback);
		if(produto){
			produtosDAO.remove(produto, callback);
		}
	});
}

/*
create database casadocodigo_nodejs;

use casadocodigo_nodejs;

CREATE TABLE produtos (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  titulo varchar(255) DEFAULT NULL,
  descricao text,
  preco decimal(10,2) DEFAULT NULL);

insert into produtos(titulo, descricao, preco)
values ('Comecando com nodejs', 'livro introdutório sobre nodejs', 39.90);

insert into produtos(titulo, descricao, preco)
values ('Comecando com javascript', 'livro introdutório sobre javascript', 39.90);

insert into produtos(titulo, descricao, preco)
values ('Comecando com express', 'livro introdutório sobre express', 39.90);
*/