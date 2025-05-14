<template>
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-lg-4 mb-4">
        <EmpleadoForm />
      </div>

      <div class="col-lg-8">
        <EmpleadoList />
      </div>
    </div>
  </div>
</template>

<script setup>
import EmpleadoForm from '../components/EmpleadoForm.vue';
import EmpleadoList from '../components/EmpleadoList.vue';
</script>
