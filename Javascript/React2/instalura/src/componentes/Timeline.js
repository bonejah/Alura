import React, { Component } from 'react';
import Foto from './Foto';
import TimelineStore from '../logicas/TimelineStore';

export default class Timeline extends Component {

  constructor(props){
    super(props);
    this.state = {fotos:[]};
    this.login = this.props.login;
  }

  componentWillMount() {
    this.props.logicaTimeline.subscribe(fotos => {
      this.setState({fotos});
    })
  }

  carregaFotos(){
    let urlPerfil;

    if (this.login === undefined) {
      urlPerfil = `http://localhost:8080/api/fotos?X-AUTH-TOKEN=${localStorage.getItem('auth-token')}`;
    } else {
      urlPerfil = `http://localhost:8080/api/public/fotos/${this.login}`;
    }
    
    this.props.logicaTimeline.lista(urlPerfil);
  }

  componentDidMount(){
    this.carregaFotos();
  }

  componentWillReceiveProps(nextProps) {
    if(nextProps.login !== undefined) {
      this.login = nextProps.login;
      this.carregaFotos();
    }
  }

  like(fotoId) {
    this.props.logicaTimeline.like(fotoId);
  }

  comenta(fotoId, textoComentario) {
    this.props.logicaTimeline.comenta(fotoId, textoComentario);
  }

  render(){
      return (
      <div className="fotos container">
          {
            this.state.fotos.map(foto => <Foto key={foto.id} foto={foto} like={this.like.bind(this)} comenta={this.comenta.bind(this)}/>)
          }                
      </div>            
      );
  }
}