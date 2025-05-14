import axios from 'axios';

const API_URL = 'http://localhost:8080/api/empleados';

export const createEmpleado = (empleado) => {
  return axios.post(API_URL, empleado);
};

