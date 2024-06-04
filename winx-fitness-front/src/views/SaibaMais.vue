<template>
   <header class="header">
    <a href="/"><img src="../assets/logo-winx-fitness.svg" alt=""></a>
    <nav class="nav">
      <button class="btn-mobile" @click="toggleMenu">
        <i class="bx" :class="{'bx-menu': !isMenuOpen, 'bx-x': isMenuOpen}" style="color: #ff0000;" id="menuIcon"></i>
      </button>
      <ul class="menu" :class="{ 'active': isMenuOpen }">
        <li><router-link to="/" class="router-link">Home</router-link></li>
        <li><router-link to="/registerStudent" class="router-link">Quero ser Aluno</router-link></li>
        <li><router-link to="/SouProfessor" class="router-link">Quero ser Professor</router-link></li>
        <li><router-link to="/Login" class="botao router-link" >Login</router-link></li>
      </ul>
    </nav>
  </header>
  <div class="responsive-container-block bigContainer">
  <div class="responsive-container-block Container">
    <div class="imgContainer">
      <img src="../assets/Group-2.svg" alt="Tela de fundo">
    </div>
    <div class="responsive-container-block textSide">
      <p class="text-blk heading">
        Sobre nós
      </p>
      <p class="text-blk subHeading">
        Somos a Winx Fitness, acreditamos que cada jornada de fitness é única e merece atenção personalizada. Com uma equipe de personal trainers altamente qualificados e experientes, estamos aqui para apoiar você em sua jornada rumo aos seus objetivos de condicionamento físico. <br> <br>
        Nossos treinadores são mais do que profissionais experientes; eles são parceiros comprometidos com o seu sucesso. Com programas de treinamento personalizados e um compromisso contínuo com o seu progresso, nossa equipe está dedicada a ajudá-lo a superar obstáculos e alcançar resultados duradouros.
      </p>
      <div class="responsive-cell-block wk-desk-6 wk-ipadp-6 wk-tab-12 wk-mobile-12">
        <div class="cardImgContainer">
          <img class="cardImg" src="../assets/crossfit.svg">
        </div>
        <div class="cardText">
          <p class="text-blk cardHeading" style="color: #074173;">
            Crossfit
          </p>
          <p class="text-blk cardSubHeading" style="color: #000;">
            Treinamento intenso para resultados rápidos.
          </p>
        </div>
      </div>
      <div class="responsive-cell-block wk-desk-6 wk-ipadp-6 wk-tab-12 wk-mobile-12">
        <div class="cardImgContainer">
          <img class="cardImg" src="../assets/peso.svg">
        </div>
        <div class="cardText">
          <p class="text-blk cardHeading" style="color: #074173;">
            Pesos
          </p>
          <p class="text-blk cardSubHeading" style="color: #000;">
            Fortalecimento e resistência em cada levantamento.
          </p>
        </div>
      </div>
      <div class="responsive-cell-block wk-desk-6 wk-ipadp-6 wk-tab-12 wk-mobile-12">
        <div class="cardImgContainer">
          <img class="cardImg" src="../assets/exercicios.svg">
        </div>
        <div class="cardText">
          <p class="text-blk cardHeading" style="color: #074173;">
            Exercícios
          </p>
          <p class="text-blk cardSubHeading" style="color: #000;">
            Movimento e suor para desafiar e fortalecer seu corpo.
          </p>
        </div>
      </div>
      
      <router-link to="/registerStudent" class="explore">Explore nossos serviços</router-link>
    </div>

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
* {
  font-family: Nunito, sans-serif;
}

body {
  background: #e3e3e3;
}

 
.text-blk {
  margin-top: 0px;
  margin-right: 0px;
  margin-bottom: 0px;
  margin-left: 0px;
  line-height: 25px;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}

.responsive-cell-block {
  min-height: 75px;
}

.responsive-container-block {
  min-height: 75px;
  height: fit-content;
  width: 100%;
  padding-top: 10px;
  padding-right: 10px;
  padding-bottom: 10px;
  padding-left: 10px;
  display: flex;
  flex-wrap: wrap;
  margin-top: 0px;
  margin-right: auto;
  margin-bottom: 0px;
  margin-left: auto;
  justify-content: flex-start;
}

.responsive-container-block.bigContainer {
  padding-top: 0px;
  padding-right: 50px;
  padding-bottom: 0px;
  padding-left: 50px;
  margin-top: 50px;
  margin-right: 0px;
  margin-bottom: 50px;
  margin-left: 0px;
}

.responsive-container-block.Container {
  max-width: 1320px;
  justify-content: space-evenly;
  align-items: center;
  padding-top: 10px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 10px;
  position: relative;
  overflow-x: hidden;
  overflow-y: hidden;
  margin-top: 0px;
  margin-right: auto;
  margin-bottom: 0px;
  margin-left: auto;
}

.mainImg {
  width: 100%;
  height: 800px;
  object-fit: cover;
}

.blueDots {
  position: absolute;
  top: 150px;
  right: 15%;
  z-index: -1;
  left: auto;
  width: 80%;
  height: 500px;
  object-fit: cover;
}

.imgContainer {
  position: relative;
  width: 48%;
  
}

.imgContainer img {
  height: auto;
  margin-left: 100px;
}

.responsive-container-block.textSide {
  width: 48%;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 20px;
  padding-left: 0px;
  z-index: 100;
}

.text-blk.heading {
  font-size: 36px;
  line-height: 40px;
  font-weight: 700;
  margin-top: 0px;
  margin-right: 0px;
  margin-bottom: 40px;
  margin-left: 0px;
}

.text-blk.subHeading {
  font-size: 18px;
  line-height: 26px;
  margin-top: 0px;
  margin-right: 0px;
  margin-bottom: 20px;
  margin-left: 0px;
}

.cardImg {
  width: 31px;
  height: 31px;
}

.cardImgContainer {
  padding-top: 20px;
  padding-right: 20px;
  padding-bottom: 20px;
  padding-left: 20px;
  border-top-width: 1px;
  border-right-width: 1px;
  border-bottom-width: 1px;
  border-left-width: 1px;
  border-top-style: solid;
  border-right-style: solid;
  border-bottom-style: solid;
  border-left-style: solid;
  border-top-color: rgb(229, 229, 229);
  border-right-color: rgb(229, 229, 229);
  border-bottom-color: rgb(229, 229, 229);
  border-left-color: rgb(229, 229, 229);
  border-image-source: initial;
  border-image-slice: initial;
  border-image-width: initial;
  border-image-outset: initial;
  border-image-repeat: initial;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  border-bottom-left-radius: 10px;
  margin-top: 0px;
  margin-right: 10px;
  margin-bottom: 0px;
  margin-left: 0px;
}

.responsive-cell-block.wk-desk-6.wk-ipadp-6.wk-tab-12.wk-mobile-12 {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 10px;
  padding-right: 15px;
  padding-bottom: 10px;
  padding-left: 0px;
}

.text-blk.cardHeading {
  font-size: 18px;
  line-height: 28px;
  font-weight: 700;
  margin-top: 0px;
  margin-right: 0px;
  margin-bottom: 10px;
  margin-left: 0px;
}

.text-blk.cardSubHeading {
  color: rgb(153, 153, 153);
  line-height: 22px;
}

.explore {
  font-size: 18px;
  line-height: 20px;
  font-weight: 700;
  color: white;
  text-decoration: none;
  background-color: #074173;
  box-shadow: #052d56;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  border-bottom-left-radius: 10px;
  cursor: pointer;
  border-top-width: 0px;
  border-right-width: 0px;
  border-bottom-width: 0px;
  border-left-width: 0px;
  border-top-style: initial;
  border-right-style: initial;
  border-bottom-style: initial;
  border-left-style: initial;
  border-top-color: initial;
  border-right-color: initial;
  border-bottom-color: initial;
  border-left-color: initial;
  border-image-source: initial;
  border-image-slice: initial;
  border-image-width: initial;
  border-image-outset: initial;
  border-image-repeat: initial;
  padding-top: 17px;
  padding-right: 40px;
  padding-bottom: 17px;
  padding-left: 40px;
  margin-top: 35px;
}

.explore:hover {
  background-image: initial;
  background-position-x: initial;
  background-position-y: initial;
  background-size: initial;
  background-attachment: initial;
  background-origin: initial;
  background-clip: initial;
  background-color: #052d56; 
}

#ixvck {
  margin-top: 60px;
  margin-right: 0px;
  margin-bottom: 0px;
  margin-left: 0px;
}

.redDots {
  position: absolute;
  bottom: -350px;
  right: -100px;
  height: 500px;
  width: 400px;
  object-fit: cover;
  top: auto;
}

@media (max-width: 1024px) {
  .responsive-container-block.Container {
    position: relative;
    align-items: flex-start;
    justify-content: center;
  }

  .mainImg {
    bottom: 0px;
  }

  .imgContainer {
    position: absolute;
    bottom: 0px;
    left: 0px;
    height: auto;
    width: 60%;
  }

  .responsive-container-block.textSide {
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
    margin-left: auto;
    width: 70%;
  }

  .responsive-container-block.Container {
    flex-direction: column-reverse;
  }

  .imgContainer {
    position: relative;
    width: auto;
    margin-top: 0px;
    margin-right: auto;
    margin-bottom: 0px;
    margin-left: auto;
  }

  .responsive-container-block.textSide {
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 20px;
    margin-left: 0px;
    width: 100%;
  }

  .responsive-container-block.Container {
    flex-direction: row-reverse;
  }

  .responsive-container-block.Container {
    flex-direction: column-reverse;
  }
}

@media (max-width: 768px) {
  .responsive-container-block.textSide {
    width: 100%;
    align-items: center;
    flex-direction: column;
    justify-content: center;
  }

  .text-blk.subHeading {
    text-align: center;
    font-size: 17px;
    max-width: 520px;
  }

  .text-blk.heading {
    text-align: center;
  }

  .imgContainer {
    opacity: 0;
  }

  .imgContainer {
    height: 500px;
  }

  .imgContainer {
    width: 30px;
  }

  .responsive-container-block.Container {
    flex-direction: column-reverse;
  }

  .responsive-container-block.Container {
    flex-wrap: nowrap;
  }

  .responsive-container-block.textSide {
    width: 100%;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 20px;
    margin-left: 0px;
  }

  .imgContainer {
    width: 90%;
  }

  .imgContainer {
    height: 450px;
    margin-top: 5px;
    margin-right: 33.9062px;
    margin-bottom: 0px;
    margin-left: 33.9062px;
  }

  .redDots {
    display: none;
  }

  .explore {
    font-size: 16px;
    line-height: 14px;
  }
}

@media (max-width: 500px) {
  .imgContainer {
    position: static;
    height: 450px;
  }

  .mainImg {
    height: 100%;
  }

  .blueDots {
    width: 100%;
    left: 0px;
    top: 0px;
    bottom: auto;
    right: auto;
  }

  .imgContainer {
    width: 100%;
  }

  .responsive-container-block.textSide {
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
    margin-left: 0px;
  }

  .responsive-container-block.Container {
    padding-top: 0px;
    padding-right: 0px;
    padding-bottom: 0px;
    padding-left: 0px;
    overflow-x: visible;
    overflow-y: visible;
  }

  .responsive-container-block.bigContainer {
    padding-top: 10px;
    padding-right: 20px;
    padding-bottom: 10px;
    padding-left: 20px;
    padding: 0 30px 0 30px;
  }

  .redDots {
    display: none;
  }

  .text-blk.subHeading {
    font-size: 16px;
    line-height: 23px;
  }

  .text-blk.heading {
    font-size: 28px;
    line-height: 28px;
  }

  .responsive-container-block.textSide {
    margin-top: 40px;
    margin-right: 0px;
    margin-bottom: 50px;
    margin-left: 0px;
  }

  .imgContainer {
    margin-top: 5px;
    margin-right: auto;
    margin-bottom: 0px;
    margin-left: auto;
    width: 100%;
    position: relative;
  }

  .explore {
    padding-top: 17px;
    padding-right: 0px;
    padding-bottom: 17px;
    padding-left: 0px;
    width: 100%;
  }

  #ixvck {
    width: 90%;
    margin-top: 40px;
    margin-right: 0px;
    margin-bottom: 0px;
    margin-left: 0px;
    font-size: 15px;
  }

  .blueDots {
    bottom: 0px;
    width: 100%;
    height: 80%;
    top: 10%;
  }

  .text-blk.cardHeading {
    font-size: 16px;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 8px;
    margin-left: 0px;
    line-height: 25px;
  }

  .responsive-cell-block.wk-desk-6.wk-ipadp-6.wk-tab-12.wk-mobile-12 {
    padding-top: 10px;
    padding-right: 0px;
    padding-bottom: 10px;
    padding-left: 0px;
  }
}
</style>