import axios from "axios";

const API_URL = "http://localhost:8080/api/checkout";

export const obtenerCheckouts = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

export const crearCheckout = async (checkout) => {
  const response = await axios.post(API_URL, checkout);
  return response.data;
};
