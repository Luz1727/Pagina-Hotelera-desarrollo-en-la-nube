<template>
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-lg-4 mb-4">
        <CheckinForm />
      </div>

      <div class="col-lg-8">
        <CheckinList />
      </div>
    </div>
  </div>
</template>

<script setup>
import CheckinForm from '@/components/CheckinForm.vue';
import CheckinList from '@/components/CheckinList.vue';
</script>
