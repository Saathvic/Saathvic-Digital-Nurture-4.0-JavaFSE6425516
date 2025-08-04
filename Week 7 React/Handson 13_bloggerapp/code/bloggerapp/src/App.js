import React from 'react';

function App() {
  const booklist = [
    { id: 101, name: "Master React", price: 670 },
    { id: 102, name: "Deep Dive into Angular 11", price: 800 },
    { id: 103, name: "Mongo Essentials", price: 450 }
  ];

  return (
    <div style={{ display: 'flex', justifyContent: 'space-around', padding: '20px' }}>
      {/* Course Details */}
      <div>
        <h3>Course Details</h3>
        <p>Angular</p>
        <p>React</p>
      </div>

      {/* Book Details */}
      <div>
        <h3>Book Details</h3>
        {
          booklist.map(book => (
            <div key={book.id}>
              <b>{book.name}</b><br />
              <span>{book.price}</span>
              <hr />
            </div>
          ))
        }
      </div>

      {/* Blog Details */}
      <div>
        <h3>Blog Details</h3>
        <p>React Learning</p>
        <p>Installation</p>
      </div>
    </div>
  );
}

export default App;
