<template>
  <div class="container">
    <div class="header">
      <logo/>
      <div class="user">
        <img src="https://www.w3schools.com/howto/img_avatar.png" alt="user">
        Minha conta
      </div>
    </div>
    <div class="content">
      <h1>Personals</h1>

      <div class="title-filters">
        <div class="filter">
          <select>
            <option value="">Filtro especialidades</option>
            <option value="Musculação">Musculação</option>
            <option value="Yoga">Yoga</option>
            <option value="Pilates">Pilates</option>
          </select>
          <input type="text" placeholder="Pesquisar por nome">
          <button>A-Z</button>
        </div>
      </div>
      <div class="professionals">
        <div v-for="professional in professionals" :key="professional.id" class="professional">
          <img :src="professional.image" :alt="professional.image">
          <h2>{{ professional.nome }}</h2>
          <div class="rating">
            <p>Especialidades: {{ professional.especialidade }}</p> 
          </div>
          <p>Valor: R$ {{professional.valorAula}}</p>
          <button>Contratar</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import logo from '../components/logo.vue'
import clienteHttp from '../http/index.ts';

export default {
  components: {
    logo
  },
  data() {
    return {
      professionals: []
    };
  },
  mounted() {
    this.fetchProfessionals();
  },
  methods: {
    async fetchProfessionals() {
      try {
        const response = await clienteHttp.get('/personal');
        this.professionals = response.data;
      } catch (error) {
        console.error('Erro ao carregar professionals:', error);
      }
    },
  }
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  padding: 20px;
  background-color: #f0f0f0;
}

.logo {
  font-size: 24px;
  font-weight: bold;
}

.user {
  display: flex;
  align-items: center;
}

.user img {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  margin-right: 10px;
}

.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 80%;
  margin: 20px auto;
}

.title-filters {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  width: 100%;
  margin-bottom: 20px;
}

h1 {
  font-size: 32px;
  font-weight: bold;
  margin: 0;
  margin-bottom: 1%;
}

.filter {
  display: flex;
  align-items: center;
}

.filter select {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-right: 10px;
}

.filter input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-right: 10px;
}

.filter button {
  padding: 10px 20px;
  background-color: #074173;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.professionals {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
  width: 60%;
}

.professional {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  border: 1px solid #ccc; /* Se precisar de uma borda, mantenha esta linha */
  border-radius: 5px; /* Bordas arredondadas */
  background-color: #fff; /* Fundo branco */
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);  /* Sombra suave para melhor visual */
  width: 100%; /* Certifique-se de que os cards ocupem toda a largura disponível */
  box-sizing: border-box; /* Inclui padding e border no tamanho total do elemento */
  border:none;
  transition: box-shadow 0.3s ease;
}
.professional:hover {
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.2); /* Sombra mais pronunciada ao passar o mouse */
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  width: 100%;
  box-sizing: border-box;
}
.professional img {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  margin-bottom: 10px;
}

.professional h2 {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 5px;
  text-align: center;
}

.professional .rating {
  font-size: 16px;
  margin-bottom: 5px;
  text-align: center;
}

.professional p {
  font-size: 14px;
  margin-bottom: 5px;
  text-align: center;
}

.professional button {
  padding: 10px 20px;
  background-color: #074173;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
}
</style>