import Pubsub from 'pubsub-js';

export default class LogicaTimeLime {

  constructor(fotos) {
    this.fotos = fotos;
  }

  lista(urlPerfil) {
    fetch(urlPerfil)
    .then(response => response.json())
    .then(fotos => {
      this.fotos = fotos;
      Pubsub.publish('timeline', this.fotos)
    });  
  }

  comenta(fotoId, textoComentario ) {
    const requestInfo = {
      method: 'POST',
      body:JSON.stringify({texto: textoComentario}),
      headers: new Headers({
        'Content-type':'application/json'
      })
    }

    fetch(`http://localhost:8080/api/fotos/${fotoId}/comment?X-AUTH-TOKEN=${localStorage.getItem('auth-token')}`, requestInfo)
    .then(response => {
      if(response.ok) {
        return response.json();
      } else {
        throw new Error("não foi possível comentar");
      }
    })
    .then(novoComentario => {
      const fotoEncontrada = this.fotos.find(foto => foto.id === fotoId);
      fotoEncontrada.comentarios.push(novoComentario);
      Pubsub.publish('timeline', this.fotos)
    });
  }

  like(fotoId) {
    fetch(`http://localhost:8080/api/fotos/${(fotoId)}/like?X-AUTH-TOKEN=${localStorage.getItem('auth-token')}`, {method: 'POST'})
    .then(response => {
      if(response.ok) {
        return response.json();
      } else {
        throw new Error("não foi possível realizar o lije da foto");
      }
    })
    .then(liker => {
      console.log(liker)
      const fotoEncontrada = this.fotos.find(foto => foto.id === fotoId);
      fotoEncontrada.likeada = !fotoEncontrada.likeada;
      const possivelLiker = fotoEncontrada.likers.find(likerAtual => likerAtual.login === liker.login);
      console.log(possivelLiker)
      if(possivelLiker === undefined) {
        fotoEncontrada.likers.push(liker);
      } else {
        const novosLikers = fotoEncontrada.likers.filter(likerAtual => likerAtual.login !== liker.login);
        fotoEncontrada.likers = novosLikers;
      }

      Pubsub.publish('timeline', this.fotos)
    });
  }

  subscribe(callback) {
    Pubsub.subscribe('timeline', (topico,fotos) => {
      callback(fotos);
    });
  }
}