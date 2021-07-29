import './App.css';
import PosterRowItem from "./ui/components/PosterRow/PosterRowItem";
import BackDropRowItem from "./ui/components/BackdropRow/BackdropRowItem";
import api from "./data/remote/api/request";

function App() {
  return (
    <div>
      <h1>Netflix Clone!</h1>
      <div className="row">
        <PosterRowItem title="Netflix Originals" url={api.NetflixOriginal} />
        <BackDropRowItem title="Trending Movies" url={api.trendingMovies} />
        <BackDropRowItem title="Trending Series" url={api.trendingSeries} />
        <BackDropRowItem title="Horror" url={api.horrorMovies} />
        <BackDropRowItem title="Action" url={api.actionMovies} />
        <BackDropRowItem title="Comedy" url={api.comedyMovies} />
        <BackDropRowItem title="Romance" url={api.romanceMovies} />
        <BackDropRowItem title="Sci-fi" url={api.sciFiMovies} />
        <BackDropRowItem title="Discover Movies" url={api.discoverMovies} />
        <BackDropRowItem title="Discover Series" url={api.discoverSeries} />
      </div>
    </div>
  );
}

export default App;
