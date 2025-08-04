import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('Euro');

  const handleSubmit = () => {
    let convertedAmount;

    if (currency === 'Euro') {
      convertedAmount = parseFloat(amount) * 80; // Sample rate
    } else {
      convertedAmount = parseFloat(amount); // Default fallback
    }

    alert(`Converting to ${currency} Amount is ${convertedAmount}`);
  };

  return (
    <div>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <label>
        Amount:
        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
      </label>
      <br /><br />
      <label>
        Currency:
        <select value={currency} onChange={(e) => setCurrency(e.target.value)}>
          <option value="Euro">Euro</option>
        </select>
      </label>
      <br /><br />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default CurrencyConvertor;
