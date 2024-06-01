<template>
    <div class="container">
      <header class="header">
        <a href="/" class="botao">Login</a>
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
      <h2>Gerenciamento de Exercícios</h2>
      <div class="buttons">
        <button @click="deleteSelected" class="delete-all"><i class="fas fa-trash"></i> Apagar</button>
        <button @click="showForm" class="add-exercise"><i class="fas fa-plus"></i> Adicionar Exercício</button>
      </div>
      <table>
        <thead>
          <tr>
            <th></th>
            <th>Nome</th>
            <th>Email</th>
            <th>Nome do Exercício</th>
            <th>Agrupamento Muscular</th>
            <th>Séries</th>
            <th>Repetições</th>
            <th>Peso</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(exercise, index) in exercises" :key="index">
            <td><input type="checkbox" v-model="exercise.selected"></td>
            <td>{{ exercise.name }}</td>
            <td><a :href="'mailto:' + exercise.email">{{ exercise.email }}</a></td>
            <td>{{ exercise.exerciseName }}</td>
            <td>{{ exercise.muscleGroup }}</td>
            <td>{{ exercise.series }}</td>
            <td>{{ exercise.repetitions }}</td>
            <td>{{ exercise.weight }}</td>
            <td class="actions">
              <button @click="editExercise(index)" class="edit"><i class="fas fa-edit"></i></button>
              <button @click="deleteExercise(index)" class="delete"><i class="fas fa-trash-alt"></i></button>
            </td>
          </tr>
        </tbody>
      </table>
      <div v-if="showExerciseForm" class="form-group">
        <input type="text" v-model="form.name" placeholder="Nome">
        <input type="email" v-model="form.email" placeholder="Email">
        <input type="text" v-model="form.exerciseName" placeholder="Nome do Exercício">
        <input type="text" v-model="form.muscleGroup" placeholder="Agrupamento Muscular">
        <input type="number" v-model="form.series" placeholder="Séries">
        <input type="number" v-model="form.repetitions" placeholder="Repetições">
        <input type="text" v-model="form.weight" placeholder="Peso">
        <button @click="saveExercise" class="add-exercise">Salvar</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        currentEditRow: null,
        isMenuOpen: false,
        showExerciseForm: false,
        exercises: [],
        form: {
          name: '',
          email: '',
          exerciseName: '',
          muscleGroup: '',
          series: '',
          repetitions: '',
          weight: ''
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
        const { name, email, exerciseName, muscleGroup, series, repetitions, weight } = this.form;
        if (name && email && exerciseName && muscleGroup && series && repetitions && weight) {
          const formData = { name, email, exerciseName, muscleGroup, series, repetitions, weight };
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
          name: '',
          email: '',
          exerciseName: '',
          muscleGroup: '',
          series: '',
          repetitions: '',
          weight: ''
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
    background-color: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 80%;
    max-width: 1000px;
    margin-top: 20px;
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
  