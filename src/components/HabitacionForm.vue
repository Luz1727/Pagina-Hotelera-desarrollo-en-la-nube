<template>
    <div class="card shadow-lg border-0 rounded-4">
      <div class="card-header bg-primary text-white text-center">
        <h4><i class="bi bi-door-open me-2"></i>Registrar Nueva Habitación</h4>
      </div>
  
      <div class="card-body">
        <form @submit.prevent="submitForm">
          <!-- Tipo -->
          <div class="mb-3">
            <label class="form-label fw-semibold">Tipo de habitación</label>
            <input v-model="habitacion.tipo" class="form-control form-control-lg shadow-sm" placeholder="Suite, Doble, Sencilla" required />
          </div>
  
          <!-- Precio -->
          <div class="mb-3">
            <label class="form-label fw-semibold">Precio por noche</label>
            <input v-model="habitacion.precio" type="number" step="0.01" class="form-control form-control-lg shadow-sm" placeholder="1000.00" required />
          </div>
  
          <!-- Estado -->
          <div class="mb-3">
            <label class="form-label fw-semibold">Estado</label>
            <select v-model="habitacion.estado" class="form-control form-control-lg shadow-sm" required>
              <option value="">Seleccione</option>
              <option value="disponible">Disponible</option>
              <option value="ocupada">Ocupada</option>
            </select>
          </div>
  
          <!-- Botón -->
          <div class="d-grid">
            <button type="submit" class="btn btn-success btn-lg shadow-sm">
              <i class="bi bi-check-circle me-2"></i>Guardar Habitación
            </button>
          </div>
        </form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { reactive } from 'vue';
  import { crearHabitacion } from '@/services/habitacionService';
  
  const habitacion = reactive({
    tipo: '',
    precio: '',
    estado: ''
  });
  
  const submitForm = async () => {
    try {
      await crearHabitacion(habitacion);
      alert('Habitación registrada correctamente');
      habitacion.tipo = '';
      habitacion.precio = '';
      habitacion.estado = '';
    } catch (error) {
      console.error('Error al registrar habitación', error);
      alert('Error al registrar habitación');
    }
  };
  </script>
  