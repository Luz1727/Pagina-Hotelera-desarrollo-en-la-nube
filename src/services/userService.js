import axios from "axios";

const API_URL = "http://localhost:8080/api/users"; // Tu endpoint actual

export const loginUser = async (email, password) => {
  const response = await axios.get(API_URL);
  const users = response.data;

  // Esto es solo una simulación básica de autenticación
  const user = users.find(
    (u) => u.email === email && u.password === password
  );

  if (!user) {
    throw new Error("Credenciales inválidas");
  }

  return user;
};
