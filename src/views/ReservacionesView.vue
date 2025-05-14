<template>
    <div>
      <h2>Reservaciones</h2>
      <table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Habitación</th>
            <th>Fecha Entrada</th>
            <th>Fecha Salida</th>
            <th>No. Personas</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="reservacion in reservaciones" :key="reservacion.id">
            <td>{{ reservacion.id }}</td>
            <td>{{ reservacion.cliente.nombre }} {{ reservacion.cliente.apellido }}</td>
            <td>{{ reservacion.habitacion.tipo }} ({{ reservacion.habitacion.estado }})</td>
            <td>{{ formatDate(reservacion.fechaEntrada) }}</td>
            <td>{{ formatDate(reservacion.fechaSalida) }}</td>
            <td>{{ reservacion.numeroPersonas }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  // Asegúrate de importar axios al inicio
  import axios from 'axios';
  
  export default {
    data() {
      return {
        reservaciones: [], // Almacenará las reservaciones obtenidas desde la API
      };
    },
    mounted() {
      this.fetchReservaciones(); // Llama a la función para cargar las reservaciones al montar el componente
    },
    methods: {
      async fetchReservaciones() {
        try {
          const response = await axios.get("http://localhost:8080/api/reservaciones");
          this.reservaciones = response.data; // Asigna los datos de la API al array de reservaciones
        } catch (error) {
          console.error("Error al obtener reservaciones:", error);
        }
      },
      formatDate(date) {
        const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
        return new Date(date).toLocaleDateString('es-ES', options); // Formatea la fecha para mostrarla en español
      }
    }
  };
  </script>
  