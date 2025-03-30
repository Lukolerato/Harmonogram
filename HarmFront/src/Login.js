import { useState } from "react";
import axios from "axios";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/auth/login", { username, password });
      setMessage(response.data === "SUCCESS" ? "Zalogowano pomyślnie!" : "Błędne dane logowania.");
    } catch (error) {
      setMessage("Błąd serwera.");
    }
  };

  return (
    <div>
      <h2>Logowanie</h2>
      <form onSubmit={handleLogin}>
        <input type="text" placeholder="Nazwa użytkownika" value={username} onChange={(e) => setUsername(e.target.value)} required />
        <input type="password" placeholder="Hasło" value={password} onChange={(e) => setPassword(e.target.value)} required />
        <button type="submit">Zaloguj</button>
      </form>
      <p>{message}</p>
    </div>
  );
}

export default Login;
