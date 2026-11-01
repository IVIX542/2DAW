function AnimalList() {

    /* Array de objetos animal */
    const animals = [
        {
            id: 1,
            name: "dog"
        },
        {
            id: 2,
            name: "cat"
        },
        {
            id: 3,
            name: "bird"
        }
    ]

    /* Creamos un map con la lista de animales formateada */
    const HTMLAnimals = animals.map((animal) => {
        return (
        <li key={animal.id}>
            <h3>{animal.name}</h3>
        </li>
    )
    })

  return (
    <section>
        <h2>Animals:</h2>
        <ul>
            {HTMLAnimals}
        </ul>
    </section>
  )
}

export default AnimalList