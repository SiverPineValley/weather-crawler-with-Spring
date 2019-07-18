import React from 'react';
import logo from '../logo.svg';

const Header = ({name, foo}) => {

    return (
      <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div>Hello! {name}, {foo}</div>
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
      </header>
    )
}

    export default Header;