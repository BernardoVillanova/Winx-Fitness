import { createRouter, createWebHistory } from 'vue-router'

import Home from './views/Home.vue'
import Sobre from './views/Sobre.vue'
import registerStudent from './views/registerStudent.vue'
import SouProfessor from './views/SouProfessor.vue'
import Login from './views/loginScreen.vue'
import Exercicio from './views/MondayExercise.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
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
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
