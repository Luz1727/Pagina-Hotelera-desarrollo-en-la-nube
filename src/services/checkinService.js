import axios from "axios";

const API_URL = "http://localhost:8080/api/checkin";

export const obtenerCheckins = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

export const crearCheckin = async (checkin) => {
  const response = await axios.post(API_URL, checkin);
  return response.data;
};
