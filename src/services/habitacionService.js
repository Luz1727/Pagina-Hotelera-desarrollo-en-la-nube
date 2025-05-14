import axios from "axios";

const API_URL = "http://localhost:8080/api/habitaciones";

export const obtenerHabitaciones = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

export const crearHabitacion = async (habitacion) => {
  const response = await axios.post(API_URL, habitacion);
  return response.data;
};
