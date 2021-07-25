import './App.css';
import RowItem from "./ui/components/rowItem/RowItem";
import api from "./data/remote/api/request";

function App() {
  return (
    <div>
      <h1>Netflix Clone!</h1>
      <RowItem title="Netflix Originals" url={api.NetflixOriginal} />
      <RowItem title="Trending Movies" url={api.trendingMovies} />
      <RowItem title="Trending Series" url={api.trendingSeries} />
    </div>
  );
}

export default App;
