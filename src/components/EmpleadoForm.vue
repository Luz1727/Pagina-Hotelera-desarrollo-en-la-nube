<template>
  <div class="card shadow-lg border-0 rounded-4">
    <div class="card-header bg-primary text-white text-center">
      <h4><i class="bi bi-person-plus me-2"></i>Registrar Nuevo Empleado</h4>
    </div>

    <div class="card-body">
      <form @submit.prevent="submitForm">
        <!-- Nombre -->
        <div class="mb-3">
          <label class="form-label fw-semibold">Nombre</label>
          <input v-model="empleado.nombre" class="form-control form-control-lg shadow-sm" placeholder="Juan" required />
        </div>

        <!-- Puesto -->
        <div class="mb-3">
          <label class="form-label fw-semibold">Puesto</label>
          <input v-model="empleado.puesto" class="form-control form-control-lg shadow-sm" placeholder="Gerente" required />
        </div>

        <!-- Botón -->
        <div class="d-grid">
          <button type="submit" class="btn btn-success btn-lg shadow-sm">
            <i class="bi bi-check-circle me-2"></i>Guardar Empleado
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import { createEmpleado } from '../services/empleadoService'; // Asegúrate de tener el servicio empleadoService

const empleado = reactive({
  nombre: '',
  puesto: ''
});

const submitForm = async () => {
  try {
    await createEmpleado(empleado);
    alert('Empleado registrado correctamente');
    empleado.nombre = '';
    empleado.puesto = '';
    // Puedes emitir un evento para recargar la tabla, si quieres
  } catch (error) {
    console.error('Error al registrar empleado', error);
    alert('Error al registrar empleado');
  }
};
</script>
