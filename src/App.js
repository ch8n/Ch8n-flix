import './App.css';

function App() {
  return (
    <div>
      <h1>Hello ch8n! {process.env.REACT_APP_TMDB_API}</h1>
      <RowItem title="Netflix Originals" url="" />
      <RowItem title="Trending Now" url="" />
    </div>
  );
}

export default App;
