import { createRouter, createWebHistory } from 'vue-router'

import Home from './views/Home.vue'
import Sobre from './views/Sobre.vue'
import registerStudent from './views/registerStudent.vue'
import SouProfessor from './views/SouProfessor.vue'
import Login from './views/loginScreen.vue'
import Exercicio from './views/listarExercicio.vue'
import listarPersonal from './views/listarPersonal.vue'
import cadastroEx from './views/cadastroEx.vue'
import listarExercicio from './views/listarExercicio.vue'

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
    path: '/listarExercicio',
    name: 'listarExercicio',
    component: listarExercicio
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
    path: '/listarPersonal',
    name: 'listarPersonal',
    component: listarPersonal
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
