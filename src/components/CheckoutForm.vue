<template>
    <div>
      <form @submit.prevent="submitForm">
        <div class="mb-3">
          <label class="form-label">Cliente ID</label>
          <input v-model="checkout.cliente.id" type="number" class="form-control" required />
        </div>
        <div class="mb-3">
          <label class="form-label">Fecha de Checkout</label>
          <input v-model="checkout.fechaCheckout" type="datetime-local" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-primary">Registrar Checkout</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { reactive } from 'vue';
  import axios from 'axios';
  
  const checkout = reactive({
    cliente: {
      id: null
    },
    fechaCheckout: ''
  });
  
  const submitForm = async () => {
    try {
      // Verifica que el cliente tenga un ID válido y fechaCheckout esté en el formato correcto
      const response = await axios.post("http://localhost:8080/api/checkout", checkout);
      alert('Checkout registrado correctamente');
      checkout.cliente.id = null;
      checkout.fechaCheckout = '';
    } catch (error) {
      console.error('Error al registrar checkout', error);
      alert('Error al registrar checkout');
    }
  };
  </script>
  