<template>
  <div class="card shadow-lg border-0 rounded-4">
    <div class="card-header bg-primary text-white text-center">
      <h4><i class="bi bi-person-plus me-2"></i>Registrar Nuevo Huésped</h4>
    </div>
    
    <div class="card-body">
      <form @submit.prevent="submitForm">
        <!-- Nombre -->
        <div class="mb-3">
          <label class="form-label fw-semibold">Nombre</label>
          <input v-model="cliente.nombre" class="form-control form-control-lg shadow-sm" placeholder="Juan" required />
        </div>

        <!-- Apellido -->
        <div class="mb-3">
          <label class="form-label fw-semibold">Apellido</label>
          <input v-model="cliente.apellido" class="form-control form-control-lg shadow-sm" placeholder="Pérez" required />
        </div>

        <!-- Teléfono -->
        <div class="mb-3">
          <label class="form-label fw-semibold">Teléfono</label>
          <input v-model="cliente.telefono" class="form-control form-control-lg shadow-sm" placeholder="555-1234567" required />
        </div>

        <!-- Email -->
        <div class="mb-4">
          <label class="form-label fw-semibold">Email</label>
          <input v-model="cliente.email" type="email" class="form-control form-control-lg shadow-sm" placeholder="correo@hotel.com" required />
        </div>

        <!-- Botón -->
        <div class="d-grid">
          <button type="submit" class="btn btn-success btn-lg shadow-sm">
            <i class="bi bi-check-circle me-2"></i>Guardar Huésped
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import { createCliente } from '../services/clienteService';

const cliente = reactive({
  nombre: '',
  apellido: '',
  telefono: '',
  email: ''
});

const submitForm = async () => {
  try {
    await createCliente(cliente);
    alert('Cliente registrado correctamente');
    cliente.nombre = '';
    cliente.apellido = '';
    cliente.telefono = '';
    cliente.email = '';
  } catch (error) {
    console.error('Error al registrar huésped', error);
    alert('Error al registrar huésped');
  }
};
</script>

