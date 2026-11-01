function Login(props) {

    const usuario = {
        username : "Iván",
        email : "ivan@email.com"
    }

    const handleClick = () => {
        props.handleLogin(usuario);
    }

  return (
    <section>
        <h2>Login Section</h2>
        <button onClick={handleClick}>Login</button>
    </section>
  )
}

export default Login