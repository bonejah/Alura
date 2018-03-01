import Vue from 'vue' // Global View
import App from './App.vue'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import { routes } from './routes';

Vue.use(VueResource);
Vue.use(VueRouter);

const router = new VueRouter({
  routes,
  mode: 'history' // Importante para retirar a tralha da URL
});

// View Instance
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
