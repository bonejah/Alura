import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource'
import VueRouter from 'vue-router'
import { routes } from './routes'
import VeeValidate from 'vee-validate'
import msg from './pt_BR'
import 'bootstrap/dist/css/bootstrap.css'
import './assets/css/test.css'
import './assets/js/test.js'
import './directives/Transform'

import 'jquery/dist/jquery.js'
import 'bootstrap/dist/js/bootstrap.js'

Vue.use(VueResource)
Vue.use(VueRouter)
Vue.use(VeeValidate, {
  locale: 'pt_BR',
  dictionary: {
    pt_BR: {
      messages: msg
    }
  }
})

Vue.http.options.root = 'http://localhost:3000'; // Definindo o Domain da API

const router = new VueRouter({ 
  routes, 
  mode: 'history'
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})

