describe("Paciente", function(){

  it("deve calcular o imc", function(){
    var bruno = new Paciente("Bruno", 36, 85, 1.77);
    expect(bruno.imc()).toEqual(85 / (1.77 * 1.77));
  });

  it("deve calcular o imc 2", function(){
    var bruno = new Paciente("Leticia", 33, 80, 1.77);

    var imc = bruno.imc();
    expect(imc).toEqual(80 / (1.77 * 1.77));
  });
});