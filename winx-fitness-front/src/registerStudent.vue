<template>
    <div>
      <div class="background"></div>
      <h1 class="logo">
        <span class="winx">Winx</span>
        <span class="fitness">FITNESS</span>
      </h1> 
      <img src="./assets/telaCadAluno.png" class="background-image" alt="Imagem de fundo" />
      <div class="login-container">
        <h2 class="login-title" style="font-weight: bold; color:#0c7474;">Cadastro Aluno</h2>
        <form @submit.prevent="login" class="form">
          <div class="form-group">
            <input type="email" id="email" v-model="email" required class="input" placeholder="Email" />
          </div>
          <div class="form-group">
            <input type="password" id="password" v-model="password" required class="input" placeholder="Senha" />
          </div>
          <div class="form-group">
            <input type="password" id="confirmPassword" v-model="confirmPassword" required class="input" placeholder="Confirme a Senha"/>
          </div>
          <div class="form-group">
            <label for="freq" class="label">Frequencia de Atividade Fisica</label>
            <div class="radio-group">
              <input type="radio" name="freq" id="sedentary">
              <label for="sedentary">Sedentário</label>
  
              <input type="radio" name="freq" id="moderate">
              <label for="moderate">Moderado</label>
  
              <input type="radio" name="freq" id="intense">
              <label for="intense">Intenso</label>
            </div>
          </div>
          <div class="form-group">
            <input type="text" id="pes" v-model="peso" required class="input" placeholder="Peso" />
          </div>
          <div class="form-group">
            <input type="text" id="altu" v-model="altura" required class="input" placeholder="Altura" />
          </div>
          <button @mouseover="hoverEffect" @mouseout="hoverEffect" @click="validatePassword" type="submit" class="login-button">Enviar</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  
  export default {
    data() {
      return {
        email: '',
        password: '',
        confirmPassword: '',
        peso: '',
        altura: '',
      };
    },
  
    methods: {
      validatePassword() {
        if (this.password !== this.confirmPassword) {
          alert('As senhas não coincidem.');
          return false;
        } else {
          return true;
        }
      },
      login() {
        // Verificar se a senha está válida antes de enviar
        if (!this.validatePassword()) {
          // Se a senha não for válida, exibir mensagem de erro e não enviar o formulário
          return;
        }
  
        // Se a senha for válida, adicione a lógica de envio do formulário aqui
        // Por exemplo, você pode usar uma chamada para enviar os dados para o servidor
        console.log('Formulário enviado com sucesso!');
      },
      },
    }
  
  </script>
  
  <style scoped>
  
  .logo {
    color: #0c7474;
    font-size: 3.5vw;
    margin-bottom: 2rem;
    font-weight: bold;
    position: absolute;
    top: 2%;
    left: 2%;
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
    width:30%; 
    position: absolute;
    top: 40%;
    z-index: 1;
    transform: translateX(18%); 
  }
  
  #email, #password, #confirmPassword {
    width: 100%; 
  }
  
  .login-container {
    position: absolute;
    top: 50%;
    right: 5%;
    transform: translateY(-50%);
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 5rem;
    width: 37%;
    height: 75%;
    max-height: 85vh;
    background-color: rgb(233, 232, 232);
    border-radius: 1rem;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    
  }
  
  
  .login-title {
    font-size: 2.5rem;
    margin-bottom: 2rem;
  }
  
  .form-group {
    display: flex;
    flex-direction: column;
    box-sizing: border-box; 
    margin-bottom: 40px;
    width: 100%;
    width: 100%;
    
  }
  
  .form-group input{
    height: 1.5rem;
    font-size: 1.4rem;
    padding: 1rem;
    border-radius: 0.5rem;
    background-color: #e9e9e9;
    border: none;
  }
  
  .radio-group {
    display: flex;
  }
  
  .radio-group label {
    margin-top: 1%;
    font-size: 1.2rem;
    margin-right: 1em;
    margin-left: 0.5em;
    font-weight: bold;
  }
  
  .radio-group input {
    width: 1rem;
  }
  
  .label {
    font-size: 1.4rem;
    margin-bottom: 0.5rem;
    font-weight: bold;
  }
  
  .input:focus {
  outline: none; 
  }
  
  .login-button {
    width: 100%;
    height: 4rem;
    font-size: 1.2rem;
    background-color: #0c7474;
    color: white;
    border: none;
    border-radius: 0.5rem;
    cursor: pointer;
    margin-bottom: 3rem;
  }
  
  .login-button:hover {
    background-color: #45a049;
  }
  
  .register-link {
    font-size: 1.2rem;
    margin-top: 2rem;
    color: black;
  }
  
  .register-link a {
    color: #0c7474;
    text-decoration: none;
  }
  
  .register-link a:hover {
    text-decoration: underline;
  }
  
  .register-link-green {
  color: #0c7474;
  font-weight: bold
  }
  
  .login-button:hover {
  background-color: #0f969c;
  transition: background-color 0.3s ease; 
  }
  
  .input {
    transition: all 0.3s ease;
    box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
  }
  
  .input:focus {
    border-color: #0c7474;
    box-shadow: 0 0 0 3px rgba(12, 116, 116, 0.1); 
  }
  
  .output {
    transition: all 0.3s ease;
    box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
  }
  
  .output:focus {
    border-color: #0c7474;
    box-shadow: 0 0 0 3px rgba(56, 112, 126, 0.623); 
  }
  
  .login-button {
    transition: background-color 0.3s ease;
  }
  
  .login-button:hover {
    background-color: #0f969c;
  }
  
  </style>
  