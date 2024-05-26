package br.com.winxfitnessbackend.controller;

import br.com.winxfitnessbackend.config.ManualAuth;
import br.com.winxfitnessbackend.dto.AlunoDto;
import br.com.winxfitnessbackend.dto.ExercicioDto;
import br.com.winxfitnessbackend.service.AlunoService;
import jakarta.servlet.ServletRequest;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping("/aluno")
    public ResponseEntity<List<AlunoDto>> buscaTodosAlunos(ServletRequest request) {
        try {
            ManualAuth.validaAuth(request);
            return ResponseEntity.ok(alunoService.findAll());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("aluno")
    public ResponseEntity<Void> insereNovoExercicio(ServletRequest request, @RequestBody AlunoDto alunoDto) {
        try {
            ManualAuth.validaAuth(request);
            alunoService.insereNovoAluno(alunoDto);
            return ResponseEntity.accepted().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/aluno/{id}")
    public ResponseEntity<Void> atualizaAluno(ServletRequest request, @PathVariable("id") Long id, @RequestBody AlunoDto alunoDto) {
        try {
            ManualAuth.validaAuth(request);
            alunoService.atualizaAluno(id, alunoDto);
            return ResponseEntity.accepted().build();

        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<Void> deletaAluno(ServletRequest request, @PathVariable("id") Long id) {
        try {
            ManualAuth.validaAuth(request);
            alunoService.deleteAluno(id);
            return ResponseEntity.accepted().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
