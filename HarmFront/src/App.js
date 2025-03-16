import { useEffect, useState } from "react";
import api from "./api";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    api.get("/hello")
      .then(response => setMessage(response.data))
      .catch(error => console.error("Błąd API:", error));
  }, []);

  return (
    <div>
      <h1>React + Spring Boot</h1>
      <p>{message}</p>
    </div>
  );
}

export default App;
