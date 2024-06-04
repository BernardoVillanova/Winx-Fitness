<template>
  <div class="wrapper">
    <div class="background"></div>
    <a href="/" class="logo"><img src="../assets/logo-winx-fitness.svg" alt="Logo"></a>

    <img src="../assets/telaCadAluno.png" class="background-image" alt="Imagem de fundo" />
    <div class="login-container">
      <h2 class="login-title">Cadastro Personal</h2>
      <form @submit.prevent="submitForm" class="form">
        <div class="form-group">
          <input type="text" id="nome" v-model="nome" required class="input" placeholder="Nome" />
        </div>
        <div class="form-group">
          <input type="email" id="email" v-model="email" required class="input" placeholder="Email" />
        </div>
        <div class="form-group">
          <input type="password" id="password" v-model="password" required class="input" placeholder="Senha" />
        </div>
        <div class="form-group">
          <input type="password" id="confirmPassword" v-model="confirmPassword" required class="input" placeholder="Confirme a Senha" />
        </div>
        <div class="form-group">
          <label for="birthdate" class="label">Data de Nascimento</label>
          <input type="date" id="birthdate" v-model="birthdate" required class="input" />
        </div>
        <div class="form-group">
          <label for="especialidade" class="label">Especialidade</label>
          <input type="text" id="especialidade" v-model="especialidade" required class="input" placeholder="Especialidade" />
        </div>
        <div class="form-group">
          <label for="experiencia" class="label">Anos de Experiência</label>
          <input type="number" id="experiencia" v-model="experiencia" required class="input" placeholder="Anos de Experiência" />
        </div>
        <button @mouseover="hoverEffect" @mouseout="hoverEffect" @click="submitForm" type="submit" class="login-button">Enviar</button>
      </form>
    </div>
  </div>

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
</template>

<script>
import clienteHttp from '../http/index.ts';

export default {
  data() {
    return {
      nome: '',
      email: '',
      password: '',
      confirmPassword: '',
      birthdate: '',
      especialidade: '',
      experiencia: ''
    };
  },

  methods: {
    validatePassword() {
      if (this.password !== this.confirmPassword) {
        alert('As senhas não coincidem.');
        return false;
      }
      return true;
    },
    async submitForm() {
      if (!this.validatePassword()) {
        return;
      }

      const formData = {
        nome: this.nome,
        email: this.email,
        password: this.password,
        birthdate: this.birthdate,
        especialidade: this.especialidade,
        experiencia: this.experiencia
      };

      try {
        const formDataJSON = JSON.stringify(formData);
        const httpRequest = await clienteHttp.post('/personal', formDataJSON).then(
          resposta => alert(resposta.data)
        );

        alert('Formulário salvo com sucesso!');
      } catch (error) {
        console.error('Erro ao salvar formulário:', error);
        alert('Erro ao salvar formulário. Por favor, tente novamente.');
      }
    }
  }
}
</script>

<style scoped>
  body {
    overflow: hidden;
  }

  .logo {
    color: #0c7474;
    font-size: 3.5vw;
    margin-bottom: 2rem;
    font-weight: bold;
    position: absolute;
    padding: 3rem 3rem;
    top: 2%;
    left: 9%;
  }

  .winx {
    color: white;
    font-weight: lighter;
    text-shadow: 1px 1px rgba(145, 144, 144, 0.5);
  }

  .fitness {
    color: #0c7474;
    font-weight: bold;
  }

  .background {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: #d3d2d2;
    z-index: -1;
  }

  .background-image {
    width: 25%;
    position: absolute;
    top: 40%;
    left: 18%;
    transform: translateX(-18%);
    z-index: 1;
  }

  #email,
  #password,
  #confirmPassword {
    width: 150%;
  }

  .login-container {
    position: absolute;
    top: 50%;
    right: 5%;
    transform: translateY(-50%);
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 2rem;
    width: 40%;
    max-height: 85vh;
    background-color: rgb(233, 232, 232);
    border-radius: 1rem;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    overflow-y: auto;
  }

  .login-title {
    font-size: 1.8rem;
    margin-bottom: 1.5rem;
    text-align: center;
    width: 100%;
  }

  .form-group {
    display: flex;
    flex-direction: column;
    box-sizing: border-box;
    margin-bottom: 20px;
    width: 100%;
    align-items: center;
  }

  .form-group input,
  .form-group label {
    width: 150%; /* Ajuste para centralizar melhor */
    max-width: 500px; /* Limite máximo de largura */
  }

  .form-group input {
    height: 3rem;
    font-size: 1.2rem;
    padding: 0.8rem;
    border-radius: 0.5rem;
    background-color: #e9e9e9;
    border: none;
    box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
    transition: all 0.3s ease;
  }

  .form-group input:focus {
    outline: none;
    border-color: #0c7474;
    box-shadow: 0 0 0 3px rgba(12, 116, 116, 0.1);
  }

  .label {
    font-size: 1.2rem;
    margin-bottom: 0.5rem;
    font-weight: bold;
  }

  .login-button {
    width: 80%;
    max-width: 500px; /* Limite máximo de largura */
    height: 3rem;
    font-size: 1rem;
    background-color: #074173;
    color: white;
    border: none;
    border-radius: 0.5rem;
    cursor: pointer;
    margin-bottom: 1.5rem;
    transition: background-color 0.3s ease;
  }

  .login-button:hover {
    background-color: #0f969c;
  }

  footer {
    flex: 0 0 auto;
    padding: 20px;
    text-align: center;
    background: #d3d2d2;
  }

  .github-link p {
    margin: 5px 0;
  }

  .github-icon i {
    font-size: 24px;
  }

  .github-icon a {
    text-decoration: none;
  }

  .github-icon a:visited {
    color: #052d56;
    text-decoration: none;
  }

  .copyright {
    margin-top: 20px;
    color: #6c757d;
  }

  @media (max-width: 1200px) {
    .background-image {
      width: 40%;
      left: 10%;
      transform: translateX(0);
    }

    .login-container {
      width: 50%;
    }
  }

  @media (max-width: 992px) {
    .background-image {
      width: 50%;
      left: 5%;
    }

    .login-container {
      width: 60%;
    }
  }

  @media (max-width: 768px) {
    .background-image {
      width: 60%;
      left: 5%;
    }

    .login-container {
      width: 70%;
      padding: 1rem;
    }

    .login-title {
      font-size: 1.5rem;
    }

    .form-group input {
      font-size: 1rem;
    }

    .label {
      font-size: 1rem;
    }

    .login-button {
      height: 2.5rem;
      font-size: 0.9rem;
    }
  }
</style>

