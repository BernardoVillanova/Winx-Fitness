<template>
    <div class="monday-exercises">
      <header>
        <h1>Dia da Semana</h1>
      </header>
      <div class="exercise-list">
        <ExerciseCard
          v-for="exercise in exercises"
          :key="exercise.id"
          :image="exercise.image"
          :title="exercise.title"
          :description="exercise.description"
        />
      </div>
    </div>
  </template>
  
  <script>
  import ExerciseCard from '@/components/ExerciseCard.vue';
  
  export default {
    name: 'MondayExercises',
    components: {
      ExerciseCard
    },
    data() {
      return {
        exercises: [
          {
            id: 1,
            image: 'path/to/rosca-martelo.jpg',
            title: 'Rosca Martelo',
            description: 'Exercício focado no bíceps e em específico para o braquiorradial.'
          },
          {
            id: 2,
            image: 'path/to/encolhimento.jpg',
            title: 'Encolhimento',
            description: 'Exercício focado no trapézio e em específico para a parte superior das costas.'
          },
          {
            id: 3,
            image: 'path/to/supino-reto.jpg',
            title: 'Supino Reto',
            description: 'Exercício focado no peitoral e em específico para a parte central do peito.'
          }
        ]
      };
    }
  };
  </script>
  
  <style scoped>
  .monday-exercises {
    padding: 16px;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  header {
    text-align: center;
    margin-bottom: 24px;
  }
  
  .exercise-list {
    display: flex;
    flex-wrap: wrap;
    gap: 16px;
    justify-content: center;
  }
  
  .exercise-card {
    flex: 1 1 calc(33.333% - 32px);
    max-width: 300px;
    box-sizing: border-box;
  }
  </style>
  