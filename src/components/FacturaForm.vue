<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Registrar Factura</h2>
    <form @submit.prevent="submitForm" class="p-4 shadow-lg rounded-3 bg-light">
      <div class="mb-3">
        <label for="clienteId" class="form-label">ID Cliente:</label>
        <input id="clienteId" type="number" v-model="factura.clienteId" class="form-control" required />
      </div>

      <div class="mb-3">
        <label for="empleadoId" class="form-label">ID Empleado:</label>
        <input id="empleadoId" type="number" v-model="factura.empleadoId" class="form-control" required />
      </div>

      <div class="mb-3">
        <label for="fechaFacturacion" class="form-label">Fecha de Facturación:</label>
        <input id="fechaFacturacion" type="datetime-local" v-model="factura.fechaFacturacion" class="form-control" required />
      </div>

      <div class="mb-3">
        <label for="formaPago" class="form-label">Forma de Pago:</label>
        <input id="formaPago" type="text" v-model="factura.formaPago" class="form-control" required />
      </div>

      <div class="mb-3">
        <label for="impuestos" class="form-label">Impuestos:</label>
        <input id="impuestos" type="number" step="0.01" v-model="factura.impuestos" class="form-control" required />
      </div>

      <div class="mb-3">
        <label for="totalPagar" class="form-label">Total a Pagar:</label>
        <input id="totalPagar" type="number" step="0.01" v-model="factura.totalPagar" class="form-control" required />
      </div>

      <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-primary w-50">Registrar Factura</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import { crearFactura } from '@/services/facturaService';

const factura = reactive({
  clienteId: null,
  empleadoId: null,
  fechaFacturacion: '',
  formaPago: '',
  impuestos: 0,
  totalPagar: 0
});

const submitForm = async () => {
  try {
    const payload = {
      cliente: { id: factura.clienteId },
      empleado: { id: factura.empleadoId },
      fechaFacturacion: factura.fechaFacturacion,
      formaPago: factura.formaPago,
      impuestos: factura.impuestos,
      totalPagar: factura.totalPagar
    };
    await crearFactura(payload);
    alert('Factura registrada correctamente');
  } catch (error) {
    console.error('Error al registrar factura', error.response?.data || error.message);
    alert('Error al registrar factura');
  }
};
</script>

<style scoped>
.container {
  max-width: 600px;
}

h2 {
  font-family: 'Arial', sans-serif;
  color: #343a40;
}

.form-control {
  border-radius: 0.375rem;
}

.btn-primary {
  font-weight: bold;
  padding: 12px;
}

.btn-primary:hover {
  background-color: #0069d9;
  border-color: #0062cc;
}

form {
  background-color: #f8f9fa;
}

label {
  font-size: 1rem;
  color: #495057;
}
</style>
