import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import HeaderComponent from './components/HeaderComponent'
import ButtonComponent from './components/ButtonComponent'

function App() {

  // Declaramos variable myPlaceHolder
  let myPlaceHolder = "Escribe aquí";

  // Variable number reactiva
  const [number, setNumber] = useState(0);

  const [greetings, setGreetings] = useState("Bienvenidos a mi web");

  // Variable myValue reactiva
  const [myValue, setMyValue] = useState("Hola");

  // Función para modificar number
  const addOne = () => {
    setNumber(number + 1);
    console.log(number);
  }

  // Función que imprime por consola "Hello!"
  const sayHello = () => {
    console.log("Hello!");
  }

  // Evento que captura el cambio a la hora de escribir en el input:text
  const handleChange = (e) => {
    console.log(e.target.value);
  }

  return (
    <>
      <HeaderComponent greetings={greetings}></HeaderComponent>

      <main className='main-content'>
        <h2 onClick={sayHello}>Hola a todos!</h2>
        
        <h2 onClick={addOne}>Number: {number}</h2>
        
        <input value={myValue} placeholder={myPlaceHolder} type="text" onChange={handleChange} />

        <br />
        <br />

        <ButtonComponent></ButtonComponent>
      </main>
    </>
  );
}

export default App
