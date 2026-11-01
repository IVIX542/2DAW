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
import MovieList from './components/MovieList'

function App() {

  // Variables  
  const links = {
    home: "Home",
    blog: "Blog",
    news: "News",
    contact: "Contact Us"
  }

  const condition = true;

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
        <h2>Hola a todos!</h2>
        <MovieList></MovieList>
      </main>
    </>
  );
}

export default App
