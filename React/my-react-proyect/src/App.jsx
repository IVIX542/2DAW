import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import HeaderComponent from './components/HeaderComponent'
import ButtonComponent from './components/ButtonComponent'

function App() {

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
      <HeaderComponent></HeaderComponent>

      <main className='main-content'>
        <h2 onClick={sayHello}>Hola a todos!</h2>
        <input type="text" onChange={handleChange} />

        <br />
        <br />
        <ButtonComponent></ButtonComponent>
      </main>
    </>
  );
}

export default App
