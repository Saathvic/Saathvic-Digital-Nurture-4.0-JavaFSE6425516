
const Listofplayers= () => {

const players = new Map([["Mr. Jack", 50 ],
    ["Mr. Michael", 70],
    ["Mr.John", 40], 
    ["Mr Ann", 61],
     ["Mr Elisabeth", 61],
      ["Mr Sachin", 95],
       ["Mr Dhoni", 100 ],
       ["Mr Virat", 84],
       ["mr jadeja", 64],
       ["Mr Raina", 75],
       ["Mr Rohit", 80]]);

       const allPlayersArray = [...players];
  const filteredPlayers = allPlayersArray.filter(([_, score]) => score < 70);

     
  return (
    <div>
      <h2>All Players and Scores</h2>
      <ul>
        {allPlayersArray.map(([name, score], index) => (
          <li key={index}>
            {name}: <span>{score}</span>
          </li>
        ))}
      </ul>

      <h2>Players with Score Below 70</h2>
      <ul>
        {filteredPlayers.map(([name, score], index) => (
          <li key={index}>
            {name}: <span>{score}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Listofplayers;