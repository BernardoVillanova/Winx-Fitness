package br.com.winxfitnessbackend.controller;


import br.com.winxfitnessbackend.dto.ExercicioDto;
import br.com.winxfitnessbackend.service.ExercicioService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {

    private ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @GetMapping
    public ResponseEntity<List<ExercicioDto>> findAll() {
        return ResponseEntity.ok(exercicioService.retornaTodosExercicios());
    }

    @PostMapping
    public ResponseEntity<Void> insereNovoExercicio(@RequestBody ExercicioDto exercicioDto) {
        exercicioService.insereNovoExercicio(exercicioDto);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> insereNovoExercicio(@PathVariable("id") Long id, @RequestBody ExercicioDto exercicioDto) {
        exercicioService.atualizaExercicio(id, exercicioDto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaExercicio(@PathVariable("id") Long id) {
        exercicioService.deleteExercicio(id);
        return ResponseEntity.accepted().build();
    }
}
