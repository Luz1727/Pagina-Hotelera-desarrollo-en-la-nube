<template>
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-lg-4 mb-4">
        <FacturaForm />
      </div>

      <div class="col-lg-8">
        <FacturaList />
      </div>
    </div>
  </div>
</template>

<script setup>
import FacturaForm from '@/components/FacturaForm.vue';
import FacturaList from '@/components/FacturaList.vue';
</script>
