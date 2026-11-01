import { useState } from 'react'

/* Assets */
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'

/* CSS */
import './App.css'

/* Components */
import HeaderComponent from './components/HeaderComponent'
import ButtonComponent from './components/ButtonComponent'
import LoginComponent from './components/LoginComponent'

function App() {

  // Variables
  let myPlaceHolder = "Escribe aquí";
  
  const links = {
    home : "Home",
    blog : "Blog",
    news : "News",
    contact : "Contact Us"
  }

  // Variables reactivas
  const [number, setNumber] = useState(0);

  const [greetings, setGreetings] = useState("Bienvenidos a mi web");

  const [myValue, setMyValue] = useState("Hola");

  const [user, setUser] = useState({});

  // Funciones
  const addOne = () => {
    setNumber(number + 1);
    console.log(number);
  }

  const sayHello = () => {
    console.log("Hello!");
  }

  const handleChange = (e) => {
    console.log(e.target.value);
  }

  const login = (userInfo) => {
    console.log(userInfo);
    setUser(userInfo);
  }

  // return principal
  return (
    <>
      <HeaderComponent greetings={greetings} links={links}></HeaderComponent>

      <main className='main-content'>
        <h2 onClick={sayHello}>Hola {user.username}</h2>
        
        <LoginComponent handleLogin={login}></LoginComponent>

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
