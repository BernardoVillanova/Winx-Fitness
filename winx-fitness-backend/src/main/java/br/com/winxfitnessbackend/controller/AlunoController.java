package br.com.winxfitnessbackend.controller;

import br.com.winxfitnessbackend.dto.AlunoDto;
import br.com.winxfitnessbackend.dto.ExercicioDto;
import br.com.winxfitnessbackend.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> buscaTodosAlunos() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> insereNovoExercicio(@RequestBody AlunoDto alunoDto) {
        alunoService.insereNovoAluno(alunoDto);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizaAluno(@PathVariable("id") Long id, @RequestBody AlunoDto alunoDto) {
        alunoService.atualizaAluno(id, alunoDto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaAluno(@PathVariable("id") Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.accepted().build();
    }
}
