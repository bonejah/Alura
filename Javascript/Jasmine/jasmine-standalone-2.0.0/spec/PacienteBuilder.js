function PacienteBuilder(){
  var nome = 'Bruno';
  var idade = 36;
  var peso = 85;
  var altura = 1.77;

  var clazz = {
    constroi : function (){
      return PacienteBuilder(nome, idade, peso, altura); 
    },

    comIdade : function(valor){
      idade += valor;
      return this;
    },

    comPeso : function(valor){
      peso += valor;
      return this;
    },

    comAltura : function(valor){
      altura += valor;
      return this;
    }
  };


  return clazz;
}