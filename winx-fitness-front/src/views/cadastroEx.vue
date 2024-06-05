<template>
  <div class="container">
    <header class="header">
      <logo/>
      <nav class="nav">
        <button class="btn-mobile" @click="toggleMenu">
          <i :class="menuIcon" id="menuIcon"></i>
        </button>
        <ul :class="{menu: true, active: isMenuOpen}" id="menu">
          <li><a href="/" class="router-link">Home</a></li>
          <li><a href="/Sobre" class="router-link">Sobre</a></li>
          <li><a href="/QueroSerAluno" class="router-link">Quero ser Aluno</a></li>
          <li><a href="/SouProfessor" class="router-link">Sou professor</a></li>
        </ul>
      </nav>
    </header>
    <h1>Gerenciamento de Exercícios</h1>
    <div class="buttons">
      <button @click="deleteSelected" class="delete-all"><i class="fas fa-trash"></i> Apagar</button>
      <button @click="showForm" class="add-exercise"><i class="fas fa-plus"></i> Adicionar Exercício</button>
    </div>
    <table>
      <thead>
        <tr>
          <th></th>
          <th>Nome do Exercício</th>
          <th>Agrupamento Muscular</th>
          <th>Séries</th>
          <th>Repetições</th>
          <th>Imagem</th>
          <th>Ações</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(exercise, index) in exercises" :key="index">
          <td><input type="checkbox" v-model="exercise.selected"></td>
          <td>{{ exercise.exerciseName }}</td>
          <td>{{ exercise.muscleGroup }}</td>
          <td>{{ exercise.series }}</td>
          <td>{{ exercise.repetitions }}</td>
          <td><img :src="exercise.image" alt="Exercise Image" width="50" height="50"></td>
          <td class="actions">
            <button @click="editExercise(index)" class="edit">Editar</button>
            <button @click="deleteExercise(index)" class="delete">Remover</button>
          </td>
        </tr>
      </tbody>
    </table>
    <div v-if="showExerciseForm" class="form-group">
      <input type="text" v-model="form.exerciseName" placeholder="Nome do Exercício">
      <input type="text" v-model="form.muscleGroup" placeholder="Agrupamento Muscular">
      <input type="number" v-model="form.series" placeholder="Séries">
      <input type="number" v-model="form.repetitions" placeholder="Repetições">
      <input type="text" v-model="form.image" placeholder="Link da Imagem">
      <button @click="saveExercise" class="add-exercise">Salvar</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import logo from '../components/logo.vue'

export default {
  components: {
    logo
  },
  data() {
    return {
      currentEditRow: null,
      isMenuOpen: false,
      showExerciseForm: false,
      exercises: [],
      form: {
        exerciseName: '',
        muscleGroup: '',
        series: '',
        repetitions: '',
        image: ''
      }
    };
  },
  computed: {
    menuIcon() {
      return this.isMenuOpen ? 'bx bx-x' : 'bx bx-menu';
    }
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    },
    showForm() {
      this.showExerciseForm = true;
      this.clearForm();
    },
    async saveExercise() {
      const { exerciseName, muscleGroup, series, repetitions, image } = this.form;
      if (exerciseName && muscleGroup && series && repetitions && image) {
        const formData = { exerciseName, muscleGroup, series, repetitions, image };
        try {
          const formDataJSON = JSON.stringify(formData);
          // await axios.post('/api/exercise', formData, { headers: { 'Content-Type': 'application/json' } });

          const blob = new Blob([formDataJSON], { type: 'application/json' });
          const link = document.createElement('a');
          link.href = window.URL.createObjectURL(blob);
          link.download = 'exercise.json';
          link.click();

          alert('Exercício salvo com sucesso!');
          
          if (this.currentEditRow !== null) {
            Object.assign(this.exercises[this.currentEditRow], formData);
            this.currentEditRow = null;
          } else {
            this.exercises.push({ ...formData, selected: false });
          }
          this.showExerciseForm = false;
        } catch (error) {
          console.error('Erro ao salvar exercício:', error);
          alert('Erro ao salvar exercício. Por favor, tente novamente.');
        }
      } else {
        alert('Preencha todos os campos.');
      }
    },
    deleteSelected() {
      this.exercises = this.exercises.filter(exercise => !exercise.selected);
    },
    editExercise(index) {
      const exercise = this.exercises[index];
      this.currentEditRow = index;
      Object.assign(this.form, exercise);
      this.showExerciseForm = true;
    },
    deleteExercise(index) {
      this.exercises.splice(index, 1);
    },
    clearForm() {
      Object.assign(this.form, {
        exerciseName: '',
        muscleGroup: '',
        series: '',
        repetitions: '',
        image: ''
      });
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
  width: 100%;
  background-color: #072e33;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
}

.header .botao {
  color: #ffffff;
  text-decoration: none;
  font-size: 16px;
}

.nav {
  position: relative;
}

.btn-mobile {
  background: none;
  border: none;
  color: #ff0000;
  font-size: 24px;
  cursor: pointer;
}

.menu {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
}

.menu li {
  margin: 0 10px;
}

.menu a {
  color: #ffffff;
  text-decoration: none;
  font-size: 16px;
}

.menu.active {
  display: block;
}

.menu {
  display: none;
}

.buttons {
  margin-top: 20px;
  display: flex;
  justify-content: space-between;
  width: 100%;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

thead {
  background-color: #072e33;
  color: #fff;
}

th,
td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th:first-child,
td:first-child {
  text-align: center;
}

.form-group {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
  margin-top: 20px;
  justify-content: center;
  width: 100%;
}

.form-group input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  flex: 1 1 100%;
  max-width: 200px;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  color: #fff;
  margin: 10px;
}

.delete-all {
  background-color: #e74c3c;
}

.add-exercise {
  background-color: #0f9b8c;
}

button.edit {
  background-color: #6da5c0;
  margin-right: 5px;
}

button.delete {
  background-color: #e74c3c;
}

button:hover {
  opacity: 0.9;
}

td a {
  color: #0c7070;
  text-decoration: none;
}

.actions {
  display: flex;
  justify-content: center;
}
</style>
