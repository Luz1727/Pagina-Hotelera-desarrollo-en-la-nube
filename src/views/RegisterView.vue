<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Registro de Usuario</h2>
    <form @submit.prevent="register">
      <div class="mb-3">
        <label>Email</label>
        <input type="email" v-model="email" class="form-control" required />
      </div>
      <div class="mb-3">
        <label>Contraseña</label>
        <input type="password" v-model="password" class="form-control" required />
      </div>
      <button type="submit" class="btn btn-primary">Registrarse</button>
    </form>
    <p class="mt-3">¿Ya tienes cuenta? <router-link to="/login">Inicia sesión</router-link></p>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const email = ref('');
const password = ref('');
const router = useRouter();

const register = async () => {
  try {
    const response = await axios.post('http://localhost:8080/api/users', {
      email: email.value,
      password: password.value,
      createdAt: new Date().toISOString() // Aseguramos que el formato de la fecha sea correcto
    });
    
    alert('Registro exitoso. Ahora puedes iniciar sesión.');
    router.push('/login');
  } catch (error) {
    console.error("Error al registrarse:", error); // Mostrar el error en la consola para ayudar en la depuración
    if (error.response) {
      // Si el error tiene respuesta del servidor
      if (error.response.status === 400) {
        alert('El correo electrónico ya está en uso.');
      } else if (error.response.status === 500) {
        alert('Hubo un problema en el servidor. Intenta más tarde.');
      } else {
        alert('Hubo un error al registrarte. Intenta nuevamente.');
      }
      console.error('Detalles del error:', error.response.data); // Ver los detalles del error en la respuesta del servidor
    } else {
      // Si no hay respuesta del servidor
      alert('Error de conexión. Intenta nuevamente.');
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: auto;
  padding: 2rem;
  background-color: #f8f9fa;
  border-radius: 10px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

h2 {
  font-size: 2rem;
}

button {
  width: 100%;
}

.error {
  color: red;
}
</style>
