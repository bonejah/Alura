var memcached = require('memcached');

module.exports = function() {
  return createMemcachedClient();
}

function createMemcachedClient() {
  var client = new memcached('localhost:11211', {
    retries: 10,
    retry: 10000,
    remove: true
  });

  return client;
}

client.set('pagamento-20', {'id':20}, 6000, function(erro){
  console.log('nova chave adicionada - pagamento-20')
});

client.get('pagamento-20', function(erro, retorno){
  if(erro || !retorno) {
    console.log('MISS - chave não encontrada') ;
  } else {
    console.log('HIT -valor: ' + JSON.stringify(retorno)); 
  }
});