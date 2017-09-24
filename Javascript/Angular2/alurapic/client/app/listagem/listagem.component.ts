import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { FotoComponent } from './../foto/foto.component';
import { FotoService } from './../foto/foto.service';

@Component({
  moduleId: module.id,
  selector: 'listagem',
  templateUrl: './listagem.component.html'
})
export class ListagemComponent {
  fotos: FotoComponent[] = [];
  service: FotoService;
  mensagem: string = '';
  
  constructor(service: FotoService) {
    this.service = service;
    this.service.lista()
      .subscribe(fotos => this.fotos = fotos,
                  erro => console.log(erro)
      );
  }

  remove(foto){
    this.service.remove(foto)
      .subscribe(
        fotos => {
          this.mensagem = 'Foto removida com sucesso';
          let novasFotos = this.fotos.slice(0);
          let indiceDaFoto = novasFotos.indexOf(foto);
          novasFotos.splice(indiceDaFoto, 1);
          this.fotos = novasFotos;
        }, 
        erro => { 
          console.log(erro);
          this.mensagem = 'Não foi possivel remover a foto';
        });
  }
}