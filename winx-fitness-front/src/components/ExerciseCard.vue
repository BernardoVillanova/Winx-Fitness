<template>
    <div class="exercise-card">
      <img :src="image" alt="Exercise Image" class="exercise-image" />
      <h3>{{ title }}</h3>
      <p>{{ description }}</p>
      <button @click="viewExercise">Visualizar</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ExerciseCard',
    props: {
      image: String,
      title: String,
      description: String
    },
    methods: {
      viewExercise() {
        alert(`Visualizar exercício: ${this.title}`);
      }
    }
  };
  </script>
  
  <style scoped>
  .exercise-card {
    background: white;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    padding: 16px;
    text-align: center;
  }
  
  .exercise-image {
    max-width: 100%;
    border-radius: 4px;
  }
  
  button {
    margin-top: 8px;
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    background: #000;
    color: white;
    cursor: pointer;
  }
  </style>
  