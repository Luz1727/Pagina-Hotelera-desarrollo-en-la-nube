<template>
  <div class="card shadow-lg border-0 rounded-4">
    <div class="card-header bg-dark text-white text-center">
      <h4><i class="bi bi-check-circle-fill me-2"></i>Checkins Registrados</h4>
    </div>

    <div class="card-body">
      <div v-if="checkins.length > 0">
        <table class="table table-striped table-bordered table-hover align-middle shadow-sm">
          <thead class="table-dark text-white">
            <tr>
              <th>Cliente</th>
              <th>Fecha Checkin</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="checkin in checkins" :key="checkin.id" class="transition-shadow hover-shadow">
              <td>{{ checkin.cliente.nombre }} {{ checkin.cliente.apellido }}</td>
              <td>{{ new Date(checkin.fechaCheckin).toLocaleString() }}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div v-else class="text-center text-muted fs-5">
        <i class="bi bi-check-circle-fill me-2"></i>Aún no hay checkins registrados.
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { obtenerCheckins } from '@/services/checkinService';

const checkins = ref([]);

const cargarCheckins = async () => {
  try {
    checkins.value = await obtenerCheckins();
  } catch (error) {
    console.error('Error al cargar checkins:', error);
  }
};

onMounted(cargarCheckins);
</script>

<style scoped>
.transition-shadow:hover {
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}
</style>

