var app = require('./config/custom-express')()

app.listen(3000, function(){
  console.log('Servidor rodando na porta 3000...')
});

app.get('/pagamentos', function(req, res){
  console.log('Recebida requisicao de teste')
  res.send('OK.')
});