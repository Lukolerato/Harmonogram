"use client"; //komponentem kliencki

import { useEffect, useState } from "react";
import axios from "axios";

const MessageComponent = () => {
  const [message, setMessage] = useState<string>("Ładowanie...");

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/message", { withCredentials: true })
      .then((response) => {
        setMessage(response.data); // Ustawiamy wiadomość
      })
      .catch((error) => {
        console.error("Błąd podczas pobierania wiadomości:", error);
        setMessage("Błąd ładowania wiadomości!");
      });
  }, []);

  return (
    <div>
        <h1>Wiadomość z backendu:</h1>
        <p>{message}</p>
    </div>
  );
};

export default MessageComponent;
