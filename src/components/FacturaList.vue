<template>
  <div class="card shadow-lg border-0 rounded-4">
    <div class="card-header bg-dark text-white text-center">
      <h4><i class="bi bi-file-earmark-list me-2"></i>Facturas Registradas</h4>
    </div>

    <div class="card-body">
      <div v-if="facturas.length > 0">
        <table class="table table-striped table-bordered table-hover align-middle shadow-sm">
          <thead class="table-dark text-white">
            <tr>
              <th>Cliente</th>
              <th>Empleado</th>
              <th>Fecha de Facturación</th>
              <th>Forma de Pago</th>
              <th>Impuestos</th>
              <th>Total a Pagar</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="factura in facturas" :key="factura.id" class="transition-shadow hover-shadow">
              <td>{{ factura.cliente.nombre }} {{ factura.cliente.apellido }}</td>
              <td>{{ factura.empleado.nombre }} ({{ factura.empleado.puesto }})</td>
              <td>{{ formatDate(factura.fechaFacturacion) }}</td>
              <td>{{ factura.formaPago }}</td>
              <td>{{ formatCurrency(factura.impuestos) }}</td>
              <td>{{ formatCurrency(factura.totalPagar) }}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div v-else class="text-center text-muted fs-5">
        <i class="bi bi-file-earmark-x-fill me-2"></i>Aún no hay facturas registradas.
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { obtenerFacturas } from '@/services/facturaService';

const facturas = ref([]);

const cargarFacturas = async () => {
  try {
    facturas.value = await obtenerFacturas();
  } catch (error) {
    console.error('Error al cargar facturas:', error);
  }
};

onMounted(cargarFacturas);

const formatDate = (date) => {
  const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
  return new Date(date).toLocaleDateString('es-ES', options);
};

const formatCurrency = (amount) => {
  if (amount == null) return '-';
  return new Intl.NumberFormat('es-MX', {
    style: 'currency',
    currency: 'MXN',
  }).format(amount);
};
</script>

<style scoped>
.transition-shadow:hover {
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}
</style>
