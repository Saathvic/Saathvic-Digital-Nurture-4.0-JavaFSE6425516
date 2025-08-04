import React from 'react';

const Indian = () => {
  const players = [
    { name: "Virat Kohli", score: 85 },
    { name: "Rohit Sharma", score: 72 },
    { name: "KL Rahul", score: 56 },
    { name: "Shreyas Iyer", score: 44 },
    { name: "Rishabh Pant", score: 60 },
    { name: "Hardik Pandya", score: 35 },
  ];

  // Split into even and odd index players
  const evenPlayers = players.filter((_, index) => index % 2 === 0);
  const oddPlayers = players.filter((_, index) => index % 2 !== 0);

  // Merge arrays (ES6 spread)
  const T20Players = ["Virat", "Pant", "Hardik"];
  const RanjiPlayers = ["Pujara", "Rahane"];
  const mergedPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div>
      <h2>Even Index Players</h2>
      <ul>
        {evenPlayers.map(({ name, score }, index) => (
          <li key={index}>{name} - {score}</li>
        ))}
      </ul>

      <h2>Odd Index Players</h2>
      <ul>
        {oddPlayers.map(({ name, score }, index) => (
          <li key={index}>{name} - {score}</li>
        ))}
      </ul>

      <h2>Merged Players (T20 + Ranji)</h2>
      <ul>
        {mergedPlayers.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Indian;
