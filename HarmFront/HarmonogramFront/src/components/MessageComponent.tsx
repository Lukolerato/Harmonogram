import { useEffect, useState } from "react";
import axios from "axios";

const MessageComponent: React.FC = () => {
  const [message, setMessage] = useState<string>("Ładowanie...");

  useEffect(() => {
    axios
      .get<string>("http://localhost:8080/api/message", { withCredentials: true })
      .then((response) => {
        setMessage(response.data);
      })
      .catch((error) => {
        console.error("Błąd pobierania wiadomości:", error);
        setMessage("Błąd ładowania wiadomości!");
      });
  }, []);

  return (
    <div style={{ padding: "20px", border: "1px solid #ddd", borderRadius: "10px" }}>
      <h2 style={{ color: "#333" }}>Wiadomość z backendu:</h2>
      <p style={{ fontSize: "18px", fontWeight: "bold" }}>{message}</p>
    </div>
  );
};

export default MessageComponent;
