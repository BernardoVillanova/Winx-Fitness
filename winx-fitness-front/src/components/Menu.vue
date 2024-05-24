<template>
  <header class="header">
    <router-link to="/" class="botao">Login</router-link>
    <nav class="nav">
      <button class="btn-mobile" @click="toggleMenu">
        <i class="bx" :class="{'bx-menu': !isMenuOpen, 'bx-x': isMenuOpen}" style="color: #ff0000;" id="menuIcon"></i>
      </button>
      <ul class="menu" :class="{ 'active': isMenuOpen }">
        <li><router-link to="/" class="router-link">Home</router-link></li>
        <li><router-link to="/Sobre" class="router-link">Sobre</router-link></li>
        <li><router-link to="/registerStudent" class="router-link">Quero ser Aluno</router-link></li>
        <li><router-link to="/SouProfessor" class="router-link">Sou professor</router-link></li>
      </ul>
    </nav>
  </header>

  <main class="introducao">
      
      <div class="introducao-texto">
        <h1>The best time for <br>sports is now</h1>
        <p>Generate Lorem Ipsum placeholder text. <br> Select the number of characters, words, <br> sentences or paragraphs, and hit generate!</p>
      </div>

      <div class="botoes">
            <router-link to="/" class="botao-2">Saiba mais</router-link>
            <router-link to="/" class="botao-3">Contato</router-link>
      </div>
    </main>
</template>

<script>
export default {
  data() {
    return {
      isMenuOpen: false
    };
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
      const menuIcon = document.getElementById('menuIcon');
      if (this.isMenuOpen) {
        menuIcon.classList.remove('bx-menu');
        menuIcon.classList.add('bx-x');
      } else {
        menuIcon.classList.remove('bx-x');
        menuIcon.classList.add('bx-menu');
      }
    }
  }
};
</script>

<style>
/* Seu estilo CSS aqui */
</style>