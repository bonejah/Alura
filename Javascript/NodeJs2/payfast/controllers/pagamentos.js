module.exports = function(app) {
  app.get('/pagamentos', function(req, res){
    console.log('Recebida requisicao de teste')
    res.send('OK.')
  });

  app.delete('/pagamentos/pagamento/:10', function(req, res){
    var pagamento = {};
    var id = req.params.id;
    pagamento.id = id;
    pagamento.status = 'CANCELADO';

    var connection = app.persistencia.connectionFactory();
    var pagamentoDAO = new app.persistencia.pagamentoDao(connection);

    pagamentoDAO.atualiza(pagamento, function(erro){
      if(erro){
        res.status(500).send(err0);
        return;
      }
      console.log('Pagamento cancelado com sucesso')
      res.send(pagamento);
    })
  });

  app.put('/pagamentos/pagamento/:id', function(req, res){
    var pagamento = {};
    var id = req.params.id;
    pagamento.id = id;
    pagamento.status = 'CONFIRMADO';

    var connection = app.persistencia.connectionFactory();
    var pagamentoDAO = new app.persistencia.pagamentoDao(connection);

    pagamentoDAO.atualiza(pagamento, function(erro){
      if(erro){
        res.status(500).send(err0);
        return;
      }
      console.log('Pagamento atualizado com sucesso')
      res.send(pagamento);
    })
  });

  app.post('/pagamentos/pagamento', function(req, res){
    req.assert('forma_de_pagamento', 'Forma de pagamento eh obrigatorio').notEmpty();
    req.assert('valor', 'Valor eh obrigatorio e deve ser um decimal').notEmpty().isFloat();
    var erros = req.validationErrors();

    if(erros){
      console.log('Erros de validacao encontrados')
      res.status(400).send(erros);
      return;
    }

    var pagamento = req.body;
    console.log('Processando uma requisição de um novo pagamento')

    pagamento.status = 'CRIADO';
    pagamento.data = new Date;

    var connection = app.persistencia.connectionFactory();
    var pagamentoDAO = new app.persistencia.pagamentoDao(connection);
   
    pagamentoDAO.salva(pagamento, function(erro, resultado){
      if(erro){
        console.log('Erro ao inserir no banco: ' + erro);
        res.status(500).send(erro);
      }else{
        console.log('pagamento criado')
        res.location('/pagamentos/pagamento/' + resultado.insertId);
        res.status(201).json(pagamento);
      }
    });

  });
}
