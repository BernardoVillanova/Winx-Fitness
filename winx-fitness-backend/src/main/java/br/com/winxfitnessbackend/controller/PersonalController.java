package br.com.winxfitnessbackend.controller;

import br.com.winxfitnessbackend.config.ManualAuth;
import br.com.winxfitnessbackend.dto.PersonalDto;
import br.com.winxfitnessbackend.service.PersonalService;
import jakarta.servlet.ServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonalController {

    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping("/personal")
    public ResponseEntity<List<PersonalDto>> buscaTodosPersonal(ServletRequest request) {
        try {
            ManualAuth.validaAuth(request);
            return ResponseEntity.ok(personalService.findAll());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/personal")
    public ResponseEntity<Void> insereNovoPersonal(ServletRequest request, @RequestBody PersonalDto personalDto) {
        try {
            ManualAuth.validaAuth(request);
            personalService.insereNovoPersonal(personalDto);
            return ResponseEntity.accepted().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/personal/{id}")
    public ResponseEntity<Void> atualizaPersonal(ServletRequest request, @PathVariable("id") Long id, @RequestBody PersonalDto personalDto) {
        try {
            ManualAuth.validaAuth(request);
            personalService.atualizaPersonal(id, personalDto);
            return ResponseEntity.accepted().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/personal/{id}")
    public ResponseEntity<Void> deletaPersonal(ServletRequest request, @PathVariable("id") Long id) {
    try {
        ManualAuth.validaAuth(request);
        personalService.deletePersonal(id);
        return ResponseEntity.accepted().build();
    } catch (Exception exception) {
        return ResponseEntity.badRequest().build();
    }
    }
}
