<template>
  <div class="bg-light min-vh-100">
    <!-- Header con estilo de lujo -->
    <header class="bg-primary text-white py-5 shadow-lg">
      <div class="container">
        <h1 class="text-center fw-bold">
          <i class="bi bi-building me-2 text-warning"></i>HOTEL EL FLOR DEL SABER
        </h1>
        <p class="text-center fs-5"></p>
      </div>
    </header>

    <!-- Vista que se muestra según la ruta -->
    <router-view />
    
  </div>
</template>

<script setup>
// Ya no necesitas importar ClientesView aquí
</script>
