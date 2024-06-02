<template>
  <div class="container">
    <div class="header">
      <div class="logo">WINX FITNESS</div>
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
          <img :src="professional.image" :alt="professional.name">
          <h2>{{ professional.name }}</h2>
          <div class="rating">
            <p>Especialidades: {{ professional.specialty }}</p> 
          </div>
          <p>{{ professional.price }}</p>
          <button>Contratar</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      professionals: []
    };
  },
  mounted() {
    this.fetchProfessionals(); // Chama a função para carregar os dados quando o componente é montado
  },
  methods: {
    async fetchProfessionals() {
      try {
        const response = await axios.get('/personals.json');
        this.professionals = response.data;
      } catch (error) {
        console.error('Erro ao carregar professionals:', error);
      }
    }
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
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.professionals {
  display: grid;
  grid-template-columns: repeat(3, 1fr); /* Três colunas */
  gap: 20px; /* Espaçamento entre os elementos */
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
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Sombra suave para melhor visual */
  width: 100%; /* Certifique-se de que os cards ocupem toda a largura disponível */
  box-sizing: border-box; /* Inclui padding e border no tamanho total do elemento */
}

.professional img {
  width: 100px;
  height: 100px;
  border-radius: 50%; /* Tornar a imagem circular */
  margin-bottom: 10px;
}

.professional h2 {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 5px;
  text-align: center; /* Centralizar texto */
}

.professional .rating {
  font-size: 16px;
  margin-bottom: 5px;
  text-align: center; /* Centralizar texto */
}

.professional p {
  font-size: 14px;
  margin-bottom: 5px;
  text-align: center; /* Centralizar texto */
}

.professional button {
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
}
</style>