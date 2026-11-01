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
  const links = {
    home : "Home",
    blog : "Blog",
    news : "News",
    contact : "Contact Us"
  }

  // Variables reactivas
  const [greetings, setGreetings] = useState("Bienvenidos a mi web");

  const [user, setUser] = useState({});

  // Funciones
  const login = (userInfo) => {
    console.log(userInfo);
    setUser(userInfo);
  }

  // return principal
  return (
    <>
      <HeaderComponent greetings={greetings} links={links}></HeaderComponent>

      <main className='main-content'>

        {/** 
         * Renderización condicional de elementos 
         * En caso de que la primera condición sea truthy, muestra el bloque. En caso
         *  contrario, no lo muestra
         * */}
        {user.username && <h2>Hola {user.username}</h2> }
        
        <LoginComponent handleLogin={login}></LoginComponent>

      </main>
    </>
  );
}

export default App
