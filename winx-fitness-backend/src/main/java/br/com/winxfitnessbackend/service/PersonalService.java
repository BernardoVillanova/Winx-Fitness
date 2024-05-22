package br.com.winxfitnessbackend.service;

import br.com.winxfitnessbackend.dto.AlunoDto;
import br.com.winxfitnessbackend.dto.PersonalDto;
import br.com.winxfitnessbackend.entity.AlunoEntity;
import br.com.winxfitnessbackend.entity.PersonalEntity;
import br.com.winxfitnessbackend.repository.AlunoRepository;
import br.com.winxfitnessbackend.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    public List<PersonalDto> findAll() {
        List<PersonalDto> personalDtoList = new ArrayList<>();

        for (PersonalEntity personalEntity : personalRepository.findAll()) {
            personalDtoList.add(new PersonalDto(personalEntity.getNome(), personalEntity.getEmail()));
        }

        return personalDtoList;
    }

    public void insereNovoPersonal(PersonalDto personalDto) {
        PersonalEntity personalEntity = new PersonalEntity();
//        alunoEntity.setNomeExercicio(exercicioDto.nome());
//        alunoEntity.setDescricao(exercicioDto.descricao());
//        alunoEntity.setImage(exercicioDto.image());

        personalRepository.save(personalEntity);
    }

    public void atualizaPersonal(Long id, PersonalDto personalDto) {
        PersonalEntity personalEntity = new PersonalEntity();
        personalEntity.setId(id);
//        alunoEntity.setNomeExercicio(exercicioDto.nome());
//        alunoEntity.setDescricao(exercicioDto.descricao());
//        alunoEntity.setImage(exercicioDto.image());

        personalRepository.save(personalEntity);
    }

    public void deletePersonal(Long id) {
        personalRepository.deleteById(id);
    }
}
