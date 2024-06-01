package br.com.winxfitnessbackend.controller;


import br.com.winxfitnessbackend.config.ManualAuth;
import br.com.winxfitnessbackend.dto.ExercicioDto;
import br.com.winxfitnessbackend.service.ExercicioService;
import jakarta.servlet.ServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExercicioController {

    private ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @GetMapping("/exercicio")
    public ResponseEntity<List<ExercicioDto>> findAll(@RequestHeader ServletRequest request) {
        try {
//            ManualAuth.validaAuth(request);
            return ResponseEntity.ok(exercicioService.retornaTodosExercicios());
        }catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/exercicio")
    public ResponseEntity<Void> insereNovoExercicio(@RequestHeader ServletRequest request, @RequestBody ExercicioDto exercicioDto) {
        try {
//            ManualAuth.validaAuth(request);
            exercicioService.insereNovoExercicio(exercicioDto);
            return ResponseEntity.accepted().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/exercicio/{id}")
    public ResponseEntity<Void> insereNovoExercicio(@RequestHeader ServletRequest request, @PathVariable("id") Long id, @RequestBody ExercicioDto exercicioDto) {
        try {
//            ManualAuth.validaAuth(request);
            exercicioService.atualizaExercicio(id, exercicioDto);
            return ResponseEntity.accepted().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/exercicio/{id}")
    public ResponseEntity<Void> deletaExercicio(@RequestHeader ServletRequest request, @PathVariable("id") Long id) {
        try {
//            ManualAuth.validaAuth(request);
            exercicioService.deleteExercicio(id);
            return ResponseEntity.accepted().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
