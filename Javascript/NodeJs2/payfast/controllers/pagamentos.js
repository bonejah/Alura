module.exports = function(app) {
  app.get('/pagamentos', function(req, res){
    console.log('Recebida requisicao de teste')
    res.send('OK.')
  });

  app.get('/pagamentos/pagamento:id', function(req, res){
    var id = req.params.id;    
    console.log('consultando o pagamento de id:'  + id);

    var connection = app.persistencia.connectionFactory();
    var pagamentoDAO = new app.persistencia.pagamentoDao(connection);
    pagamentoDao.buscaPorId(id, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }

      console.log('pagamento encontrado ' + JSON.stringify(resultado));
      res.json(resultado);      
    });
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
      res.status(204).send(pagamento);
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
    req.assert('pagamento.forma_de_pagamento', 'Forma de pagamento eh obrigatorio').notEmpty();
    req.assert('pagamento.valor', 'Valor eh obrigatorio e deve ser um decimal').notEmpty().isFloat();
    req.assert("pagamento.moeda", "Moeda é obrigatória e deve ter 3 caracteres").notEmpty().len(3,3);
    var erros = req.validationErrors();

    if(erros){
      console.log('Erros de validacao encontrados')
      res.status(400).send(erros);
      return;
    }

    var pagamento = req.body["pagamento"];
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
        pagamento.id = resultado.insertId;
        console.log('pagamento criado')

        if(pagamento.forma_de_pagamento == 'cartao') {
          var cartao = req.body["cartao"];

          var cartoesCartoes = app.servicos.cartoesClient();
          cartoesCartoes.autoriza(cartao, function(erro, request, response, retorno) {
            if(erro){
              console.log('erro ao consultar servico de cartoes')
              request.status(400).send(erro);
            }
            console.log(retorno)
            res.status(201).json(response);
            return;
          });
        }else{
          res.location('/pagamentos/pagamento/' + pagamento.id);
  
          var response = {
            dados_do_pagamento: pagamento,
            links: [
              {
                href: "http://localhost:3000/pagamentos/pagamento/" + pagamento.id,
                rel: "confirmar",
                method: "PUT"
              },
              {
                href: "http://localhost:3000/pagamentos/pagamento/" + pagamento.id,
                rel: "cancelar",
                method: "DELETE"
              }
            ]
          }
          res.status(201).json(response);
        }
      }
    });

  });
}
