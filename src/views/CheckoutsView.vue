<template>
    <div class="container py-5">
      <div class="row justify-content-center">
        <div class="col-lg-4 mb-4">
          <CheckoutForm />
        </div>
  
        <div class="col-lg-8">
          <CheckoutList />
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import CheckoutForm from '@/components/CheckoutForm.vue';
  import CheckoutList from '@/components/CheckoutList.vue';
  </script>
  