import React,{ Component } from 'react';
import Post from './Post';

class Posts extends React.Component{
    constructor(props){
        super(props);
        this.state = { posts:[],
    };
}
    loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        const postObjects = data.map(post => new Post(post.userId, post.id, post.title, post.body));
        this.setState({ posts: postObjects });
      })
      .catch(error => {
        console.error('Error fetching posts:', error);
        alert("Error fetching posts.");
      });
  };

    

    componentDidMount() {
        this.loadPosts();

    }

    componentDidCatch(error, info) {
  alert("Something went wrong in the component.");
  console.error("Caught error:", error, info);
}


    render(){
         return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );

    }
   
}

export default Posts;