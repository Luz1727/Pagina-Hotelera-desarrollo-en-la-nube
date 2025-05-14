<template>
  <div class="card shadow-lg border-0 rounded-4">
    <div class="card-header bg-dark text-white text-center">
      <h4><i class="bi bi-person-lines-fill me-2"></i>Huéspedes Registrados</h4>
    </div>

    <div class="card-body">
      <div v-if="clientes.length > 0">
        <table class="table table-striped table-bordered table-hover align-middle shadow-sm">
          <thead class="table-dark text-white">
            <tr>
              <th>Nombre</th>
              <th>Apellido</th>
              <th>TELEFONO</th>
              <th>Email</th>
              
            </tr>
          </thead>
          <tbody>
            <tr v-for="cliente in clientes" :key="cliente.id" class="transition-shadow hover-shadow">
              <td>{{ cliente.nombre }}</td>
              <td>{{ cliente.apellido }}</td>
              <td>{{ cliente.telefono }}</td>
              <td>{{ cliente.email }}</td>
              
            </tr>
          </tbody>
        </table>
      </div>
      <div v-else class="text-center text-muted fs-5">
        <i class="bi bi-person-x-fill me-2"></i>Aún no hay huéspedes registrados.
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const clientes = ref([]);

const cargarClientes = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/clientes');
    clientes.value = response.data;
  } catch (error) {
    console.error('Error al cargar huéspedes:', error);
  }
};

onMounted(cargarClientes);
</script>

<style scoped>
/* Transición para hover */
.transition-shadow:hover {
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}
</style>
