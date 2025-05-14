// src/services/facturaService.js
import axios from 'axios';

export const crearFactura = async (factura) => {
  try {
    const response = await axios.post('http://localhost:8080/api/facturas', factura);
    return response.data;
  } catch (error) {
    throw error;
  }
};

// (Opcionalmente exporta también si quieres listar facturas)
export const obtenerFacturas = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/facturas');
    return response.data;
  } catch (error) {
    throw error;
  }
};
