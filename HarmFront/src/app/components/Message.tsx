// src/app/components/Message.tsx
"use client";

import React, { useState, useEffect } from "react";
import axios from "axios";

const Message = () => {
  const [message, setMessage] = useState<string>("");

  useEffect(() => {
    axios.get("/api/message")
      .then((response) => {
        setMessage(response.data); // Zakładając, że odpowiedź to tylko tekst
      })
      .catch((error) => {
        console.error("There was an error fetching the message!", error);
      });
  }, []);

  return (
    <div>
      <h1>{message}</h1>
    </div>
  );
};

export default Message;
