<template>
  <div>
    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
      <div class="container-fluid">
        <router-link class="navbar-brand fw-bold fs-4" to="/home">
          <i class="bi bi-building"></i> Hotel El Flor del Saber
        </router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0 gap-2">
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/home"><i class="bi bi-house-door"></i> Inicio</router-link>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/clientes"><i class="bi bi-person"></i> Clientes</router-link>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/empleados"><i class="bi bi-people"></i> Empleados</router-link>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/habitaciones"><i class="bi bi-door-open"></i> Habitaciones</router-link>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/reservaciones"><i class="bi bi-calendar-check"></i> Reservaciones</router-link>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/facturas"><i class="bi bi-receipt"></i> Facturas</router-link>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/checkins"><i class="bi bi-check-circle"></i> Check-ins</router-link>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-outline-light fs-5" to="/checkouts"><i class="bi bi-check-circle"></i> Checkouts</router-link>
            </li>
            <li class="nav-item">
              <button @click="logout" class="btn btn-outline-warning btn-lg ms-3">
                <i class="bi bi-box-arrow-right"></i> Cerrar sesión
              </button>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Contenido principal -->
    <div class="container mt-4">
      <h2>Bienvenido, {{ user?.email }}</h2>
      <p>Este es el panel de control de la aplicación. Puedes ver los datos de los clientes, empleados, habitaciones, reservaciones y facturas aquí.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  data() {
    return {
      user: JSON.parse(localStorage.getItem("user")) || null,
    };
  },
  methods: {
    logout() {
      localStorage.removeItem("user");
      this.$router.push("/login");
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 900px;
}
</style>
