<template>
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-lg-4 mb-4">
        <ClienteForm />
      </div>

      <div class="col-lg-8">
        <ClienteList />
      </div>
    </div>
  </div>
</template>

<script setup>
import ClienteForm from '../components/ClienteForm.vue';
import ClienteList from '../components/ClienteList.vue';
</script>
