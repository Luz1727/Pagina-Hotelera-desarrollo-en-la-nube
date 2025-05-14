<template>
    <div class="card shadow-lg border-0 rounded-4">
      <div class="card-header bg-dark text-white text-center">
        <h4><i class="bi bi-door-open-fill me-2"></i>Habitaciones Registradas</h4>
      </div>
  
      <div class="card-body">
        <div v-if="habitaciones.length > 0">
          <table class="table table-striped table-bordered table-hover align-middle shadow-sm">
            <thead class="table-dark text-white">
              <tr>
                <th>Tipo</th>
                <th>Precio</th>
                <th>Estado</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="habitacion in habitaciones" :key="habitacion.id" class="transition-shadow hover-shadow">
                <td>{{ habitacion.tipo }}</td>
                <td>${{ habitacion.precio.toFixed(2) }}</td>
                <td>
                  <span :class="habitacion.estado === 'disponible' ? 'text-success' : 'text-danger'">
                    {{ habitacion.estado }}
                  </span>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div v-else class="text-center text-muted fs-5">
          <i class="bi bi-door-closed-fill me-2"></i>Aún no hay habitaciones registradas.
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { obtenerHabitaciones } from '@/services/habitacionService';
  
  const habitaciones = ref([]);
  
  const cargarHabitaciones = async () => {
    try {
      habitaciones.value = await obtenerHabitaciones();
    } catch (error) {
      console.error('Error al cargar habitaciones:', error);
    }
  };
  
  onMounted(cargarHabitaciones);
  </script>
  
  <style scoped>
  .transition-shadow:hover {
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  }
  </style>
  