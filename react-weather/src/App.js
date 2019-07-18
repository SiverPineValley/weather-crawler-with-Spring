import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom'

import Header from './component/header';
import Home from './component/Home'
import About from './component/About'

import './App.css';

class App extends Component {
  // AJAX Fetch한 것들을 이곳에서 정의
  componentDidMount() {
    console.log("Component DID MOUNT");
  }
  
  // Render Function
  render() {
    const name = "Jongin";
    const bar = "bar"


    return (
      <BrowserRouter>
        <div className="App">
        <Header name={name} foo={bar}/>
        <Route exact path="/" component={Home}/>
        <Route path="/about" render={About}/>
        </div>
      </BrowserRouter>

    );
  }
  
}

export default App;