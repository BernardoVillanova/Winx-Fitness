import { createRouter, createWebHistory } from 'vue-router'

import Home from './views/Home.vue';
import Sobre from './views/Sobre.vue';
import QueroSerAluno from './views/QueroSerAluno.vue';
import SouProfessor from './views/SouProfessor.vue';
const routes = [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/sobre",
      name: "sobre",
      component: Sobre
    },
    {
      path: "/QueroSerAluno",
      name: "QueroSerAluno",
      component: QueroSerAluno
    },
    {
      path: "/SouProfessor",
      name: "SouProfessor",
      component: SouProfessor
    }
];

const router = createRouter({ history: createWebHistory(), routes});

export default router;

