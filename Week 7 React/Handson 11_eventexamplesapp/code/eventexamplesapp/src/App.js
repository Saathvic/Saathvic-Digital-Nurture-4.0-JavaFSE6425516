import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);

  const sayHello = () => {
    alert("Hello! This is a static message.");
  };

  const increment = () => {
    sayHello();
    setCount(count + 1);
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayWelcome = () => {
    alert("Welcome");
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ padding: '20px' }}>
      <p>{count}</p>
      <button onClick={increment}>Increment</button>
      <br />
      <button onClick={decrement}>Decrement</button>
      <br />
      <button onClick={sayWelcome}>Say welcome</button>
      <br />
      <button onClick={handleClick}>Click on me</button>
      <br /><br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
