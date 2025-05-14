<template>
    <div class="card shadow-lg border-0 rounded-4">
      <div class="card-header bg-dark text-white text-center">
        <h4><i class="bi bi-check-circle-fill me-2"></i>Checkouts Registrados</h4>
      </div>
  
      <div class="card-body">
        <div v-if="checkouts.length > 0">
          <table class="table table-striped table-bordered table-hover align-middle shadow-sm">
            <thead class="table-dark text-white">
              <tr>
                <th>Cliente</th>
                <th>Fecha Checkout</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="checkout in checkouts" :key="checkout.id" class="transition-shadow hover-shadow">
                <td>{{ checkout.cliente.nombre }} {{ checkout.cliente.apellido }}</td>
                <td>{{ new Date(checkout.fechaCheckout).toLocaleString() }}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div v-else class="text-center text-muted fs-5">
          <i class="bi bi-check-circle-fill me-2"></i>Aún no hay checkouts registrados.
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { obtenerCheckouts } from '@/services/checkoutService';
  
  const checkouts = ref([]);
  
  const cargarCheckouts = async () => {
    try {
      checkouts.value = await obtenerCheckouts();
    } catch (error) {
      console.error('Error al cargar checkouts:', error);
    }
  };
  
  onMounted(cargarCheckouts);
  </script>
  
  <style scoped>
  .transition-shadow:hover {
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  }
  </style>
  