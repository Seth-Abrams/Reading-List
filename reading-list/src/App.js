import React, { Component } from 'react';
import './App.css';

const API = "http://localhost:8080/api";

class App extends Component {
  state = {
    isLoading: true,
    books: []
  };

  async componentDidMount() {
    const response = await fetch(API + '/books');
    const body = await response.json();
    this.setState({ books: body, isLoading: false });
  }
  render() {
    const {books, isLoading} = this.state;

    if(isLoading) {
      return <p>Loading...</p>
    }

    return (
      <div className="App">
        <header className="App-header">
            <h2>Reading List</h2>
            {books.map(book =>
                <div key={book.id}>
                  {book.title}
                </div>
            )}
        </header>
      </div>
    );
  }
}

export default App;
