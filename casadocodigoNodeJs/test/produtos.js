var express = require('../config/express')();
var request = require('supertest')(express);
//var http = require('http');
//var assert = require('assert');

describe('ProdutosController', function(){
	/* comentado pois está usando o
	it('listagem json', function(done){
		var configuracoes = {
			hostname: 'localhost',
			port:3000,
			path: '/produtos',
			headers: {
				'Accept':'application/json'
				//'Accept':'text/html',
				//'Content-type':'application/json'
			}
		};
	
		http.get(configuracoes, function(res){
			assert.equal(res.statusCode, 200);
			//assert.equal(res.statusCode, 302);
			assert.equal(res.headers['content-type'], 'application/json; charset=utf-8');
			done();
		});
		*/ 

	beforeEach(function(done){
		//node-database-cleaner - Pesquisar sobre essa biblioteca
		var conn = express.infra.connectionFactory();
		conn.query("delete from produtos", function(ex, result){
			if(!ex){
				done();
			}
		});
	})
		
	it('listagem json', function(done){	
		request.get('/produtos')
		.set('Accept','application/json')
		.expect('Content-Type',/json/)
		.expect(200,done);
	});

	it('#cadastro de novo produto com dados invalidos', function(done){
		request.post('/produtos')
		.send({titulo:"", descricao:"novo livro,", preco:""})
		.expect(400,done);
	});

	it('#cadastro de novo produto com dados validos', function(done){
		request.post('/produtos')
		.send({titulo:"Ruby on Rails", descricao:"Ruby on Rails,", preco:"50"})
		.expect(302,done);
	});


});