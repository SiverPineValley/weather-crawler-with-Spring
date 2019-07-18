import React, { Component } from 'react';

import Header from './component/header';

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
      <div className="App">
        <Header name={name} foo={bar}/>
  
      </div>
    );
  }
  
}

export default App;