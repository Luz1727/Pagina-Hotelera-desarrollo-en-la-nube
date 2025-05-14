<template>
  <div class="login-container">
    <h1>Iniciar Sesión</h1>
    <form @submit.prevent="login">
      <div>
        <label for="email">Email:</label>
        <input type="email" v-model="email" required />
      </div>
      <div>
        <label for="password">Contraseña:</label>
        <input type="password" v-model="password" required />
      </div>
      <button type="submit">Ingresar</button>
    </form>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
    <p class="text-center mt-3">
      ¿No tienes cuenta? 
      <router-link to="/register" class="btn btn-link">Regístrate aquí</router-link>
    </p>
  </div>
</template>

<script>
import { loginUser } from "@/services/userService"; // Aquí importamos loginUser

export default {
  name: "LoginView",
  data() {
    return {
      email: "",
      password: "",
      errorMessage: "",
    };
  },
  methods: {
    async login() {
      try {
        const user = await loginUser(this.email, this.password);
        console.log("Usuario autenticado:", user);
        localStorage.setItem("user", JSON.stringify(user)); // Guarda el usuario en localStorage
        this.$router.push("/home");
      } catch (error) {
        this.errorMessage = "Credenciales incorrectas.";
      }
    },
  },
};
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: auto;
  padding: 1rem;
  background: #f5f5f5;
  border-radius: 8px;
}
.error {
  color: red;
}
</style>
