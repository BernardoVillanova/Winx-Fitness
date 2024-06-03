import { createRouter, createWebHistory } from 'vue-router'

import Home from './views/Home.vue'
import Sobre from './views/Sobre.vue'
import registerStudent from './views/registerStudent.vue'
import SouProfessor from './views/SouProfessor.vue'
import Login from './views/loginScreen.vue'
import Exercicio from './views/MondayExercise.vue'
import cadastroEx from './views/cadastroEx.vue'
import SaibaMais from './views/SaibaMais.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/cadastroEx',
    name: 'cadastroEx',
    component: cadastroEx
  },
  {
    path: '/Exercicio',
    name: 'Exercicio',
    component: Exercicio
  },
  {
    path: '/Login',
    name: 'Login',
    component: Login
  },
  {
    path: '/sobre',
    name: 'sobre',
    component: Sobre
  },
  {
    path: '/registerStudent',
    name: 'registerStudent',
    component: registerStudent
  },
  {
    path: '/SouProfessor',
    name: 'SouProfessor',
    component: SouProfessor
  },
  {
    path: '/SaibaMais',
    name: 'SaibaMais',
    component: SaibaMais
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
