import React, { Component } from 'react';
import PubSub from 'pubsub-js';

export default class InputCustomizado extends Component {
	constructor(props) {
		super(props);
		this.state = {msgErro:''}
	}

	componentDidMount() {
		PubSub.subscribe("erro-validacao",function(topico,erro){
			if(erro.field === this.props.name) {
				this.setState({msgErro:erro.defaultMessage});
			}
  	}.bind(this));

  	PubSub.subscribe("limpa-erros",function(topico){
		    this.setState({msgErro:''});
		}.bind(this));
	}

	render(){
		return(
			<div className="pure-control-group">
	      <label htmlFor={this.props.id}>{this.props.label}</label>
	      <input {...this.props}/>
	      <span className="erro">{this.state.msgErro}</span>
	    </div>
		);
	}
}