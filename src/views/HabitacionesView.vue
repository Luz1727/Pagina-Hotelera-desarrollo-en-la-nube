<template>
    <div class="container py-5">
      <div class="row justify-content-center">
        <div class="col-lg-4 mb-4">
          <HabitacionForm />
        </div>
  
        <div class="col-lg-8">
          <HabitacionList />
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import HabitacionForm from '@/components/HabitacionForm.vue';
  import HabitacionList from '@/components/HabitacionList.vue';
  </script>
  