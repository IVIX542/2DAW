
function MovieList() {

    const movies = [
        "Lord of the Rings",
        "Star Wars",
        "Dune"
    ];

    /* Creamos un nuevo array que contenga un parrafo por cada elemento. Para ello,
    utilizamos una función flecha en la que indicamos el elemento y su índice. */
    const HTMLMovies = movies.map((movie, index) => {
        return <p key={movie}>{index +1} - {movie}</p> //index empieza en 1
    })

  return (
    <section>
        <h2>Movies</h2>

        {HTMLMovies}
    </section>
  )
}

export default MovieList