<template>
  <div>
    <form @submit.prevent="submitForm">
      <div class="mb-3">
        <label class="form-label">Cliente ID</label>
        <input v-model="checkin.cliente.id" type="number" class="form-control" required />
      </div>
      <div class="mb-3">
        <label class="form-label">Fecha de Check-in</label>
        <input v-model="checkin.fechaCheckin" type="datetime-local" class="form-control" required />
      </div>
      <button type="submit" class="btn btn-primary">Registrar Check-in</button>
    </form>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import axios from 'axios';

const checkin = reactive({
  cliente: {
    id: null,
    nombre: '',
    apellido: '',
    telefono: '',
    email: ''
  },
  fechaCheckin: ''
});

const submitForm = async () => {
  try {
    // Verifica que el cliente tenga un ID válido y fechaCheckin esté en el formato correcto
    const response = await axios.post("http://localhost:8080/api/checkin", checkin);
    alert('Check-in registrado correctamente');
    checkin.cliente.id = null;
    checkin.fechaCheckin = '';
  } catch (error) {
    console.error('Error al registrar checkin', error);
    alert('Error al registrar checkin');
  }
};
</script>

