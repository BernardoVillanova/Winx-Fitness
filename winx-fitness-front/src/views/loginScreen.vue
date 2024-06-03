  <template>
    <div>
      <div class="background"></div>
      <!-- Título WINX Fitness -->
      <a href="/" class="logo"><img src="../assets/logo-winx-fitness.svg" alt=""></a>
      <img src="../assets/ImgProjetoWinxFitness.png" class="background-image" alt="Imagem de fundo" />
      <!-- Div de login -->
      <div class="login-container">
        <h2 class="login-title" style="font-weight: bold; color:#074173;">Login</h2>
        <form @submit.prevent="login" class="form">
          <div class="form-group">
            <input type="email" id="email" v-model="email" required class="input" placeholder="Email  " />
          </div>
          <div class="form-group">
            <input type="password" id="password" v-model="password" required class="input" placeholder="Senha" />
          </div>
          <button @mouseover="hoverEffect" @mouseout="hoverEffect" type="submit" class="login-button">Entrar</button>
        </form>
        <p class="register-link" style="font-size: 1.3rem;">Não possui cadastro? <router-link to="/CadastroAluno" class="register-link-green">Cadastre-se</router-link></p>
      </div>
    </div>
    
  </template>


  <script>
 export default {
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    login() {
      // Coda fofo o login aqui
    },
  }
};
  
  </script>

  <style scoped>

/*css do logo */
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
/*css do logo */

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
  width:60%; 
  position: absolute;
  top: 20%;
  right: 50%;
  z-index: 1;
  transform: translateX(18%); 
}

  #email, #password {
    width: 350px; 
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
    width:37%;
    height:70%;
    max-height: 85vh;
    overflow-y: auto;
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
    height: 4.4rem;
    font-size: 1.2rem;
    padding: 1rem;
    border-radius: 0.5rem;
    background-color: #e9e9e9;
    border: none;
  }
  

  .label {
    font-size: 1.2rem;
    margin-bottom: 0.5rem;
  }

 
  .input:focus {
  outline: none; 
}

  .login-button {
    width: 100%;
    height: 4rem;
    font-size: 1.2rem;
    background-color: #074173;
    color: white;
    border: none;
    border-radius: 0.5rem;
    cursor: pointer;
    margin-top:20px;
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
    color: #074173;
    text-decoration: none;
  }

  .register-link a:hover {
    text-decoration: underline;
  }
  .register-link-green {
  color: #0c7474; /* Cor verde utilizada no login */
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
/* EFEITOS DOS INPUTS */

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