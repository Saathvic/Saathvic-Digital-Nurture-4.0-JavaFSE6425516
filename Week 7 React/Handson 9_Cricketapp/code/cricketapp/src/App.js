import React from 'react';
import Listofplayers from './Listofplayers';
import Indian from './Indian';

function App() {
  const flag = false; // Change to true/false to toggle component

  return (
    <div className="App">
      <h1>Welcome to Cricket App</h1>
      {flag ? <Listofplayers /> : <Indian />}
    </div>
  );
}

export default App;
