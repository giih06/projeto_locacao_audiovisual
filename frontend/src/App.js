import logo from './logo.svg';
import './App.css';

/* 
Conexão com o Spring
fetch('/api/livros')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Erro: ' + error));
  */
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
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
    </div>
  );
}

export default App;
