<template>
  <div class="card shadow-lg border-0 rounded-4">
    <div class="card-header bg-dark text-white text-center">
      <h4><i class="bi bi-person-lines-fill me-2"></i>Empleados Registrados</h4>
    </div>

    <div class="card-body">
      <div v-if="empleados.length > 0">
        <table class="table table-striped table-bordered table-hover align-middle shadow-sm">
          <thead class="table-dark text-white">
            <tr>
              <th>Nombre</th>
              <th>Puesto</th>
              <th>Fecha de Contratación</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="empleado in empleados" :key="empleado.id" class="transition-shadow hover-shadow">
              <td>{{ empleado.nombre }}</td>
              <td>{{ empleado.puesto }}</td>
              <td>{{ empleado.fechaContratacion.substring(0,10) }}</td> <!-- Solo fecha -->
            </tr>
          </tbody>
        </table>
      </div>
      <div v-else class="text-center text-muted fs-5">
        <i class="bi bi-person-x-fill me-2"></i>No hay empleados registrados.
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const empleados = ref([]);

const cargarEmpleados = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/empleados');
    empleados.value = response.data;
  } catch (error) {
    console.error('Error al cargar empleados:', error);
  }
};

onMounted(cargarEmpleados);
</script>

<style scoped>
.transition-shadow:hover {
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}
</style>
