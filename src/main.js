import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(router); // 👈 Aquí se conecta el enrutador
app.mount('#app');
