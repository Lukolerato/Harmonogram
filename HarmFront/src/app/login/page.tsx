"use client";

import { useState } from "react";
import axios from "axios";
import { useRouter } from "next/navigation";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const router = useRouter();

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/auth/login", { username, password });
      if (response.data === "SUCCESS") {
        setMessage("Zalogowano pomyślnie!");
        router.push("/dashboard"); // Przekierowanie po logowaniu
      } else {
        setMessage("Błędne dane logowania.");
      }
    } catch (error) {
      setMessage("Błąd serwera.");
    }
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <h2 className="text-2xl font-bold">Logowanie</h2>
      <form onSubmit={handleLogin} className="flex flex-col gap-4 mt-4">
        <input
          type="text"
          placeholder="Nazwa użytkownika"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="p-2 border border-gray-300 rounded"
          required
        />
        <input
          type="password"
          placeholder="Hasło"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="p-2 border border-gray-300 rounded"
          required
        />
        <button type="submit" className="p-2 bg-blue-500 text-white rounded">
          Zaloguj
        </button>
      </form>
      <p className="mt-4">{message}</p>
    </div>
  );
}
