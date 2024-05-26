package br.com.winxfitnessbackend.service;

import br.com.winxfitnessbackend.dto.AlunoDto;
import br.com.winxfitnessbackend.dto.ExercicioDto;
import br.com.winxfitnessbackend.entity.AlunoEntity;
import br.com.winxfitnessbackend.entity.ExercicioEntity;
import br.com.winxfitnessbackend.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDto> findAll() {
        List<AlunoDto> alunoDtoList = new ArrayList<>();

        for (AlunoEntity alunoEntity : alunoRepository.findAll()) {
            alunoDtoList.add(new AlunoDto(alunoEntity.getNome(), alunoEntity.getEmail()));
        }

        return alunoDtoList;
    }

    public void insereNovoAluno(AlunoDto alunoDto) {
        AlunoEntity alunoEntity = new AlunoEntity();
//        alunoEntity.setNomeExercicio(exercicioDto.nome());
//        alunoEntity.setDescricao(exercicioDto.descricao());
//        alunoEntity.setImage(exercicioDto.image());

        alunoRepository.save(alunoEntity);
    }

    public void atualizaAluno(Long id, AlunoDto exercicioDto) {
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setId(id);
//        alunoEntity.setNomeExercicio(exercicioDto.nome());
//        alunoEntity.setDescricao(exercicioDto.descricao());
//        alunoEntity.setImage(exercicioDto.image());

        alunoRepository.save(alunoEntity);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
