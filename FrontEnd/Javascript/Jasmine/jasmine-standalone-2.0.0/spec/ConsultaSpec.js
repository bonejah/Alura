describe('Consulta', function(){

  var bruno;

  beforeEach(function(){
    bruno = new PacienteBuilder().constroi();
  });

  describe('consultas do tipo retorno', function(){
    it('nao deve cobrar nada se for um retorno', function(){  
      var consulta = new Consulta(bruno, [], true, true);
      expect(consulta.preco()).toEqual(0);
    });
  });

  describe('consulta com procedimentos', function(){
    it('deve cobrar 25 por cada procedimento comum', function(){
      var consulta = new Consulta(bruno, ['proc1', 'proc2'], false, false);
      expect(consulta.preco()).toEqual(50);
    });
  
    it('deve cobrar preco especifico dependendo do procedimento', function(){
      var consulta = new Consulta(bruno, ['procedimento-comun', 'raio-x', 'procedimento-comum', 'gesso'], false, false);
      expect(consulta.preco()).toEqual(25 + 55 + 25 + 32);
    });
  });
});