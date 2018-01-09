var cluster = require('cluster');
var os = require('os');

var cpus = os.cpus();


console.log('executando thread')

if(cluster.isMaster){
  console.log('executando thread master')
  cpus.forEach(function(){
    cluster.fork();
  });
}else{
  console.log('executando thread slave')
  require('./index.js');
}