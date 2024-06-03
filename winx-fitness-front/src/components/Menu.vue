<template>
  <div class="img-fundo">
    <div class="wrapper">
      <header class="header">
        <a href="#"><img src="../assets/logo-winx-fitness.svg" alt=""></a>
        <nav class="nav">
          <button class="btn-mobile" @click="toggleMenu">
            <i class="bx" :class="{'bx-menu': !isMenuOpen, 'bx-x': isMenuOpen}" style="color: #ff0000;" id="menuIcon"></i>
          </button>
          <ul class="menu" :class="{ 'active': isMenuOpen }">
            <li ><router-link to="/" class="router-link">Home</router-link></li>
            <li><router-link to="/registerStudent" class="router-link">Quero ser Aluno</router-link></li>
            <li><router-link to="/SouProfessor" class="router-link">Sou professor</router-link></li>
            <li><router-link to="/Login" class="botao router-link" >Login</router-link></li>
          </ul>
        </nav>
      </header>

      <main class="introducao">
        <div class="introducao-texto">
          <h1>Agora é a hora<br> <center>do esporte.</center></h1>
          <p><center>Explore tudo que precisa para praticar,<br>competir, inspirar e evoluir em sua jornada. <br>Encontre o personal trainer ideal  para você.</center></p>
        </div>

        <div class="botoes">
          <router-link to="/SaibaMais" class="botao-2">Saiba mais</router-link>
          <router-link to="/registerStudent" class="botao-3">Inscreva-se</router-link>
        </div>
      </main>

      <footer>
        <div class="github-icon">
          <a href="https://github.com/orgs/WinxFHO/people" target="_blank"><i class="fab fa-github"></i></a>
        </div>
        <div class="github-link">
          <p>Siga-nos no GitHub!</p>
          
        </div>
        <div class="copyright">
          <p>© 2024 Winx Fitness</p>
          <p>Todos os direitos reservados.</p>
        </div>
      </footer>
    </div>
  </div>
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
body {
  height: 100%;
  margin: 0;
  background: #e3e3e3;

  background-image: url('../assets/tela-de-fundo.png');
  background-repeat: no-repeat, no-repeat;
  background-size: auto;
}

.img-fundo {
  background-image: url('../assets/tela-de-fundo.png');
  background-repeat: no-repeat, no-repeat;
  background-size: auto;
}

header {
  flex: 0 0 auto;
}

main {
  flex: 1 0 auto;
}

.wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

footer {
  flex: 0 0 auto;
  padding: 20px;
  text-align: center;
}

.github-link p {
  margin: 5px 0;
}

.github-icon i {
  font-size: 24px; /* Tamanho do ícone */
}

.github-icon a {
    text-decoration: none; /* Remove sublinhado padrão */
}

.github-icon a:visited {
    color: #052d56; /* Mantém a cor original após visitar */
    text-decoration: none; /* Remove a decoração do texto */
}

.copyright {
  margin-top: 20px;
  color: #6c757d; /* Cor cinza para o texto de direitos autorais */
}
</style>
