package br.com.winxfitnessbackend.controller;

import br.com.winxfitnessbackend.dto.PersonalDto;
import br.com.winxfitnessbackend.service.PersonalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping
    public List<PersonalDto> buscaTodosPersonal() {
        return personalService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> insereNovoPersonal(@RequestBody PersonalDto personalDto) {
        personalService.insereNovoPersonal(personalDto);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizaPersonal(@PathVariable("id") Long id, @RequestBody PersonalDto personalDto) {
        personalService.atualizaPersonal(id, personalDto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaPersonal(@PathVariable("id") Long id) {
        personalService.deletePersonal(id);
        return ResponseEntity.accepted().build();
    }
}
