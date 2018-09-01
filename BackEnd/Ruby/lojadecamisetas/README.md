# README

This README would normally document whatever steps are necessary to get the
application up and running.

Things you may want to cover:

* Commands ------------- RAILS -------------
* Command to add a new column in a table: rails g migration add_departamento_id_to_produto departamento_id:integer
* Command to genarate a structure of model: rails g scaffold Departamento nome
* Command to create a new project Rails: rails new <nameproject>
* Command to start server rails: rails server / rails s
* Command to create controllers: rails generate controller <namecontrolleronplural> / rails g controller <namecontrolleronplural>
* Command to create model: rails generate / rails g model produto nome:string descricao:text quantidade:integer preco:decimal
* Command  to enter console database: rails dbconsole
	.tables (see the tables create on database)
	.schema produtos (see structure table produtos)

* Command to install bootstrap: rails g bootstrap:install static

* Command to enter console ruby: rails console
	Comando to reload a class: reload!


* 	2.4.1 :001 > bigbang = Produto.new
	 => #<Produto id: nil, nome: nil, descricao: nil, quantidade: nil, preco: nil, created_at: nil, updated_at: nil>
	2.4.1 :002 > bigbang.nome = "Camiseta Big Bang Theory"
	2.4.1 :003 > bigbang.descricao = "Camiseta Big Bang Theory"
	2.4.1 :004 > bigbang.quantidade = 7
	2.4.1 :005 > bigbang.preco = 77.7
	2.4.1 :006 > bigbang <Produto id: nil, nome: "Camiseta Big Bang Theory", descricao: "Camiseta Big Bang Theory", quantidade: 7, preco: 0.777e2, created_at: nil, updated_at: nil> 2.4.1 :007 > bigbang.save   (0.2ms)  begin transaction
	  SQL (1.2ms)  INSERT INTO "produtos" ("nome", "descricao", "quantidade", "preco", "created_at", "updated_at") VALUES (?, ?, ?, ?, ?, ?)  [["nome", "Camiseta Big Bang Theory"], ["descricao", "Camiseta Big Bang Theory"], ["quantidade", 7], ["preco", 77.7], ["created_at", "2017-07-22 10:05:00.840061"], ["updated_at", "2017-07-22 10:05:00.840061"]]
	   (1.5ms)  commit transaction
	 => true

*  2.4.1 :020 > batman = Produto.create nome:"Camiseta do Batman", descricao:"Camiseta do Batman", quantidade:10, preco:70.7   (0.2ms)  begin transaction
	  SQL (0.6ms)  INSERT INTO "produtos" ("nome", "descricao", "quantidade", "preco", "created_at", "updated_at") VALUES (?, ?, ?, ?, ?, ?)  [["nome", "Camiseta do Batman"], ["descricao", "Camiseta do Batman"], ["quantidade", 10], ["preco", 70.7], ["created_at", "2017-07-22 10:11:36.664026"], ["updated_at", "2017-07-22 10:11:36.664026"]]
	   (2.1ms)  commit transaction
	 => #<Produto id: 3, nome: "Camiseta do Batman", descricao: "Camiseta do Batman", quantidade: 10, preco: 0.707e2, created_at: "2017-07-22 10:11:36", updated_at: "2017-07-22 10:11:36">
	2.4.1 :021 >

	2.4.1 :025 > Produto.all
	  Produto Load (0.4ms)  SELECT  "produtos".* FROM "produtos" LIMIT ?  [["LIMIT", 11]]
	 => #<ActiveRecord::Relation [#<Produto id: 1, nome: "Camiseta Big Bang Theory", descricao: "Camiseta Big Bang Theory", quantidade: 7, preco: 0.777e2, created_at: "2017-07-22 10:05:00", updated_at: "2017-07-22 10:05:00">, #<Produto id: 2, nome: "Camiseta Walking Dead", descricao: "Camiseta Walking Dead", quantidade: 100, preco: 0.5e2, created_at: "2017-07-22 10:08:19", updated_at: "2017-07-22 10:08:19">, #<Produto id: 3, nome: "Camiseta do Batman", descricao: "Camiseta do Batman", quantidade: 10, preco: 0.707e2, created_at: "2017-07-22 10:11:36", updated_at: "2017-07-22 10:11:36">]>

	 Produto.all.order <name attribute order> Ex.: Produto.all.order :nome / Produto.order :nome

* Commands ------------- RAKE -------------
* Command to create a database: rake db:create
* Command to create a table: rake db:migrate
* Command to DROP a table: rake db:drop
* Command to see all routes: rake routes / http://localhost:3000/rails/info/routes

* Ruby version
	ruby version 2.4.1

* System dependencies

* Configuration

* Database creation

* Database initialization

* How to run the test suite

* Services (job queues, cache servers, search engines, etc.)

* Deployment instructions

* ...
