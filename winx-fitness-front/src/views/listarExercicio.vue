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
      <h1>Exercícios</h1>

      <div class="title-filters">
        <div class="filter">
          <select>
            <option value="">Filtro por Grupo Muscular</option>
            <option value="Peito">Peito</option>
            <option value="Costas">Costas</option>
            <option value="Pernas">Pernas</option>
          </select>
          <input type="text" placeholder="Pesquisar por nome">
          <button>Pesquisar</button>
        </div>
      </div>
      <div class="exercises">
        <div v-for="exercise in exercises" :key="exercise.id" class="exercise">
          <img :src="exercise.image" alt="exercise image">
          <h2>{{ exercise.exerciseName }}</h2>
          <div class="details">
            <p>Agrupamento Muscular: {{ exercise.muscleGroup }}</p> 
            <p>Séries: {{ exercise.series }}</p>
            <p>Repetições: {{ exercise.repetitions }}</p>
            <p>Peso: {{ exercise.weight }} kg</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import logo from '../components/logo.vue';

export default {
  components: {
    logo
  },
  data() {
    return {
      exercises: []
    };
  },
  mounted() {
    this.fetchExercises();
  },
  methods: {
    async fetchExercises() {
      try {
        const response = await axios.get('/exercicio');
        this.exercises = response.data;
      } catch (error) {
        console.error('Erro ao carregar exercícios:', error);
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
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.exercises {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
  width: 60%;
}

.exercise {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  width: 100%;
  box-sizing: border-box;
}

.exercise img {
  width: 100px;
  height: 100px;
  border-radius: 5px;
  margin-bottom: 10px;
}

.exercise h2 {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 5px;
  text-align: center;
}

.exercise .details {
  font-size: 16px;
  margin-bottom: 5px;
  text-align: center;
}

.exercise p {
  font-size: 14px;
  margin-bottom: 5px;
  text-align: center;
}

.exercise button {
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
}
</style>
