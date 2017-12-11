class NegociacaoController {
  constructor() {
    let $ = document.querySelector.bind(document);
    this._inputData = $("#data");
    this._inputQuantidade = $("#quantidade");
    this._inputValor = $("#valor");

    this._listaNegociacoes = new Bind(
      new ListaNegociacoes(),
      new NegociacoesView($("#negociacoesView")),
      "adiciona",
      "esvazia"
    );

    this._mensagem = new Bind(
      new Mensagem(),
      new MensagemView($("#mensagemView")),
      "texto"
    );
  }

  apaga() {
    this._listaNegociacoes.esvazia();
    this._mensagem.texto = "Negociações apagadas com sucesso";
  }

  adiciona(event) {
    event.preventDefault();
    this._listaNegociacoes.adiciona(this._criaNegociacao());
    this._mensagem.texto = "Negociação adicionada com sucesso";
    this._limpaFormulario();
  }

  _criaNegociacao() {
    return new Negociacao(
      DateHelper.textoParaData(this._inputData.value),
      this._inputQuantidade.value,
      this._inputValor.value
    );
  }

  _limpaFormulario() {
    this._inputData.value = "";
    this._inputQuantidade.value = 1;
    this._inputValor.value = 0.0;
    this._inputData.focus();
  }

  importaNegociacoes() {
    let service = new NegociacaoService();

    Promise.all([
      service.obterNegociacoesDaSemana(), 
      service.obterNegociacoesDaSemanaAnterior(),  
      service.obterNegociacoesDaSemanaRetrasada()]
    ).then(negociacoes => {
      console.log(negociacoes)
      negociacoes
        .reduce((arrayAchatado, array) => arrayAchatado.concat(array), [])
        .forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
      this._mensagem.texto = 'Negociações importadas com sucesso';
    }).catch(error => this._mensagem.texto = error);
  
    /* ANTIGO 2
    service.obterNegociacoesDaSemana()
      .then(negociacoes => {
        negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao))
        this._mensagem.texto = 'Negociações da semana obtida com sucesso';
      })
      .catch(erro => this._mensagem = erro);

    service.obterNegociacoesDaSemanaAnterior()
      .then(negociacoes => {
        negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao))
        this._mensagem.texto = 'Negociações da semana anterior obtida com sucesso';
      })
      .catch(erro => this._mensagem = erro);

    service.obterNegociacoesDaSemanaRetrasada()
    .then(negociacoes => {
      negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao))
      this._mensagem.texto = 'Negociações da semana retrasada obtida com sucesso';
    })
    .catch(erro => this._mensagem = erro);
    */  

    /* ANTIGO 1
    service.obterNegociacoesDaSemnana((erro, negociacoes) => {
      if (erro) {
        this._mensagem.texto = erro;
        return;
      }

      negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));

      service.obterNegociacoesDaSemanaAnterior((erro, negociacoes) => {
        if (erro) {
          this._mensagem.texto = erro;
          return;
        }

        negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));

        service.obterNegociacoesDaSemnanaRetrasada((erro, negociacoes) => {
          if (erro) {
            this._mensagem.texto = erro;
            return;
          }

          negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
          this._mensagem.texto = "Negociações importadas com sucesso";
        });
      });
    });
    */
  }
}
