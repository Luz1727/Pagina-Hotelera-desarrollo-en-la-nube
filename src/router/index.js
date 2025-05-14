import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import LoginView from "@/views/LoginView.vue";
import ClientesView from "@/views/ClientesView.vue";
import RegisterView from "@/views/RegisterView.vue";
import EmpleadosView from "@/views/EmpleadosView.vue";
import HabitacionesView from "@/views/HabitacionesView.vue";
import ReservacionesView from "@/views/ReservacionesView.vue";
import FacturasView from "@/views/FacturasView.vue";
import CheckinsView from "@/views/CheckinsView.vue";
import CheckoutView from "@/views/CheckoutsView.vue"; 


const routes = [
  { path: '/', redirect: '/login' }, // Cuando entras a raíz, redirige a login
  { path: '/login', name: 'Login', component: LoginView },
  { path: '/register', name: 'Register', component: RegisterView },
  { 
    path: '/home', 
    name: 'Home', 
    component: HomeView,
    meta: { requiresAuth: true }, // 👈 protegida
  },
  { 
    path: '/clientes', 
    name: 'Clientes', 
    component: ClientesView,
    meta: { requiresAuth: true }, // 👈 protegida
  },
  { 
    path: '/empleados', 
    name: 'Empleados', 
    component: EmpleadosView,
    meta: { requiresAuth: true }, // 👈 protegida
  },
  {
    path: '/habitaciones', // Nueva ruta
    name: 'Habitaciones',
    component: HabitacionesView,
    meta: { requiresAuth: true }, // Ruta protegida
  },
  { 
    path: '/reservaciones', 
    name: 'Reservaciones', 
    component: ReservacionesView, 
    meta: { requiresAuth: true } // 👈 también protegida
  },
  {
    path: '/facturas',
    name: 'Facturas',
    component: FacturasView,
    meta: { requiresAuth: true }
  },
  { path: '/checkins', 
    name: 'Checkins', 
    component: CheckinsView, 
    meta: { requiresAuth: true } },
  { path: '/checkouts',
    name: 'Checkouts', 
    component: CheckoutView,
    meta: { requiresAuth: true } }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 👇 Aquí agregamos el guardia de navegación
router.beforeEach((to, from, next) => {
  const isAuthenticated = !!localStorage.getItem("user"); // existe user => autenticado

  if (to.meta.requiresAuth && !isAuthenticated) {
    next("/login"); // Si quiere entrar a algo protegido y no está autenticado, va a login
  } else {
    next(); // De lo contrario sigue normal
  }
});

export default router;
