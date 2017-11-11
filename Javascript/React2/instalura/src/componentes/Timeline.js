import React, { Component } from 'react';
<<<<<<< HEAD
import Foto from './Foto';
import TimelineStore from '../logicas/TimelineStore';
=======
import FotoItem from './Foto';
import TimelineApi from '../logicas/TimelineApi';
>>>>>>> 4354b4ad5b02723daeeb04e702f94592517f866c

export default class Timeline extends Component {

  constructor(props){
    super(props);
    this.state = {fotos:[]};
    this.login = this.props.login;
  }

<<<<<<< HEAD
  componentWillMount() {
    this.props.logicaTimeline.subscribe(fotos => {
      this.setState({fotos});
    })
=======
  componentWillMount(){
    this.props.store.subscribe(() => {
      this.setState({fotos:this.props.store.getState().timeline});
    });
>>>>>>> 4354b4ad5b02723daeeb04e702f94592517f866c
  }

  carregaFotos(){
    let urlPerfil;

    if (this.login === undefined) {
      urlPerfil = `http://localhost:8080/api/fotos?X-AUTH-TOKEN=${localStorage.getItem('auth-token')}`;
    } else {
      urlPerfil = `http://localhost:8080/api/public/fotos/${this.login}`;
    }
<<<<<<< HEAD
    
    this.props.logicaTimeline.lista(urlPerfil);
=======

    this.props.store.dispatch(TimelineApi.lista(urlPerfil));
>>>>>>> 4354b4ad5b02723daeeb04e702f94592517f866c
  }

  componentDidMount(){
    this.carregaFotos();
  }

  componentWillReceiveProps(nextProps){
    if(nextProps.login !== undefined) {
      this.login = nextProps.login;
      this.carregaFotos();
    }
  }

  like(fotoId) {
<<<<<<< HEAD
    this.props.logicaTimeline.like(fotoId);
  }

  comenta(fotoId, textoComentario) {
    this.props.logicaTimeline.comenta(fotoId, textoComentario);
=======
    this.props.store.dispatch(TimelineApi.like(fotoId));
  }

  comenta(fotoId, textoComentario ) {
    this.props.store.dispatch(TimelineApi.comenta(fotoId, textoComentario));
>>>>>>> 4354b4ad5b02723daeeb04e702f94592517f866c
  }

  render(){
      return (
      <div className="fotos container">
          {
<<<<<<< HEAD
            this.state.fotos.map(foto => <Foto key={foto.id} foto={foto} like={this.like.bind(this)} comenta={this.comenta.bind(this)}/>)
=======
            this.state.fotos.map(foto => <FotoItem key={foto.id} foto={foto} like={this.like.bind(this)} comenta={this.comenta.bind(this)}/>)
>>>>>>> 4354b4ad5b02723daeeb04e702f94592517f866c
          }                
      </div>            
      );
  }
}