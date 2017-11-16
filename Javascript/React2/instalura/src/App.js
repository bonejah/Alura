import React, { Component } from 'react';
import Header from './componentes/Header';
import Timeline from './componentes/Timeline';
import PropTypes from 'prop-types';

class App extends Component {
  render() {    
    return (
    <div id="root">
      <div className="main">
        <Header store={this.context.store}/>
        <Timeline login={this.props.params.login} store={this.context.store}/>
      </div>
    </div>  
    );
  }
}

App.contextTypes = {
<<<<<<< HEAD
  store: React.PropTypes.object.isRequired
=======
  store : PropTypes.object.isRequired
>>>>>>> e890b8bdee2867b5dfa9325abde8bd2fca6da468
};

export default App;