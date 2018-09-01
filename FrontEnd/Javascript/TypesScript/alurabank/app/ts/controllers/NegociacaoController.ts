import { NegociacoesView, MensagemView } from "../views/index";
import { Negociacoes, Negociacao, NegociacaoParcial } from "../models/index";
import { domInject, throttle } from '../helpers/decorators/index';
import { NegociacaoService } from '../services/index';
import { imprime } from '../helpers/index';

export class NegociacaoController {
  @domInject('#data')
  private _inputData: JQuery;

  @domInject('#quantidade')
  private _inputQuantidade: JQuery;

  @domInject('#valor')
  private _inputValor: JQuery;
  private _negociacoes = new Negociacoes();
  private _negociacoesView = new NegociacoesView("#negociacoesView", true);
  private _mensagemView = new MensagemView("#mensagemView");
  private _service = new NegociacaoService();

  constructor() {
    // this._inputData = $("#data");
    // this._inputQuantidade = $("#quantidade");
    // this._inputValor = $("#valor");
    this._negociacoesView.update(this._negociacoes);
  }

  @throttle()
  adiciona() {
    let data = new Date(this._inputData.val().replace(/-/g, ","));

    if (!this._ehDiaUtil(data)) {
      this._mensagemView.update("Negociações somente em dias úteis, por favor");
    }

    const negociacao = new Negociacao(
      data,
      parseInt(this._inputQuantidade.val()),
      parseFloat(this._inputValor.val())
    );
    
    this._negociacoes.adiciona(negociacao);
    this._negociacoesView.update(this._negociacoes);
    this._mensagemView.update("Negociação adicionada com sucesso");
    imprime(negociacao, this._negociacoes);
  }

  private _ehDiaUtil(data: Date) {
    return (
      data.getDay() != DiaDaSemana.Sabado && data.getDay() != DiaDaSemana.Sabado
    );
  }

  @throttle()
  async importar(){
    try {
      const negociacoesParaImportar = await this._service
      .obterNegociacoes(res => {
        if (res.ok) {
          return res;
        } else {
          throw new Error(res.statusText);
        }
      });

      const negociacoesJaImportadas = this._negociacoes.paraArray();

      negociacoesParaImportar
        .filter(negociacao => !negociacoesJaImportadas.some(jaImportada =>
          negociacao.ehIgual(jaImportada)))
        .forEach(negociacao => this._negociacoes.adiciona(negociacao));
      
      this._negociacoesView.update(this._negociacoes);
      this._mensagemView.update('Negociações importadas com sucesso')
    } catch (error) {
      this._mensagemView.update(error.message)
    }
  }


  // CODIGO ANTIGO
  // @throttle(500)
  // importar() {
  //   this._service
  //   .obterNegociacoes(res => {

  //       if(res.ok) {
  //           return res;
  //       } else {
  //           throw new Error(res.statusText);
  //       }
  //   })

  //   .then(negociacoesParaImportar => {
  //       const negociacoesJaImportadas = this._negociacoes.paraArray();

  //       negociacoesParaImportar
  //           .filter(negociacao => 
  //               !negociacoesJaImportadas.some(jaImportada => 
  //                   negociacao.ehIgual(jaImportada)))
  //           .forEach(negociacao => 
  //           this._negociacoes.adiciona(negociacao));

  //       this._negociacoesView.update(this._negociacoes);
  //       this._mensagemView.update('Negociações importadas com sucesso');
  //   })
  //   .catch(erro => this._mensagemView.update(erro.message));
  // }
}

enum DiaDaSemana {
  Domingo,
  Segunda,
  Terca,
  Quarta,
  Quinta,
  Sexta,
  Sabado
}
