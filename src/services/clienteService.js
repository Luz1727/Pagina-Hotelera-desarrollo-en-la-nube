import axios from 'axios';

const API_URL = 'http://localhost:8080/api/clientes';

export const getClientes = () => {
  return axios.get(API_URL);
};
export const createCliente = (cliente) => {
  console.log('Enviando cliente:', cliente); // debug
  return axios.post('http://localhost:8080/api/clientes', cliente);
};
export const obtenerClientes = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};


