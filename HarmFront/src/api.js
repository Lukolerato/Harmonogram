import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api", // Adres backendu
});

export const getTasks = async () => {
  const response = await api.get("/test");
  return response.data;
};

export default api;
 //todo: usunąć, albo zmienić na ge Message /message