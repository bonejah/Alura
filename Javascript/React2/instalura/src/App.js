import React, { Component } from 'react';
import Header from './componentes/Header';
import Timeline from './componentes/Timeline';
<<<<<<< HEAD
import TimelineStore from '../logicas/TimelineStore';


const timelineStore = new Timeline([]);
=======
import {createStore, applyMiddleware, combineReducers} from 'redux';
import thunkMiddleware from 'redux-thunk';
import {timeline} from './reducers/timeline';
import {notificacao} from './reducers/header';
>>>>>>> 4354b4ad5b02723daeeb04e702f94592517f866c

const reducers = combineReducers({timeline,notificacao});
const store = createStore(reducers, applyMiddleware(thunkMiddleware));

console.log(store.getState());
class App extends Component {
  render() {
    return (
    <div id="root">
      <div className="main">
<<<<<<< HEAD
        <Header/>
        <Timeline login={this.props.params.login} logicaTimeline={logicaTimeline}/>
=======
        <Header store={store}/>
        <Timeline login={this.props.params.login} store={store}/>
>>>>>>> 4354b4ad5b02723daeeb04e702f94592517f866c
      </div>
    </div>
    );
  }
}

export default App;
