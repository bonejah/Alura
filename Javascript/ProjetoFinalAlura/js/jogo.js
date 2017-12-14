var criaJogo = function(){
  var palavraSecreta = '';
  var lacunas = [];
  var etapa = 1;

  var criaLacunas = function(){
    // for(var i=0; i < palavraSecreta.length; i++) {
    //   lacunas.push('');
    // }

    lacunas = Array(palavraSecreta.length).fill('');
  }
  
  var proximaEtapa = function(){
    etapa = 2
  }

  var setPalavraSecreta = function(palavra){
    palavraSecreta = palavra;
    criaLacunas();
    proximaEtapa();
  }

  var getLacunas = function(){
    return lacunas;
  }

  var getEtapa = function(){
    return etapa;
  }

  return {
    setPalavraSecreta: setPalavraSecreta,
    getLacunas: getLacunas,
    getEtapa: getEtapa
  }
}