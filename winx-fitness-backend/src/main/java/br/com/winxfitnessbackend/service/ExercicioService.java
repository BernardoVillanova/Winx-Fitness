package br.com.winxfitnessbackend.service;

import br.com.winxfitnessbackend.dto.ExercicioDto;
import br.com.winxfitnessbackend.entity.ExercicioEntity;
import br.com.winxfitnessbackend.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    public List<ExercicioDto> retornaTodosExercicios() {
        List<ExercicioDto> exercicioDtoList = new ArrayList<>();

        try {
            for (ExercicioEntity objEntity : exercicioRepository.findAll()) {
                exercicioDtoList.add(new ExercicioDto(objEntity.getId(), objEntity.getNomeExercicio(), objEntity.getDescricao(), objEntity.getImage()));
            }
        } catch (Exception ex) {

        }

        return exercicioDtoList;
    }

    public void insereNovoExercicio(ExercicioDto exercicioDto) {
        ExercicioEntity exercicioEntity = new ExercicioEntity();
        exercicioEntity.setNomeExercicio(exercicioDto.nome());
        exercicioEntity.setDescricao(exercicioDto.descricao());
        exercicioEntity.setImage(exercicioDto.image());

        exercicioRepository.save(exercicioEntity);
    }


    public void atualizaExercicio(Long id, ExercicioDto exercicioDto) {
        ExercicioEntity exercicioEntity = new ExercicioEntity();
        exercicioEntity.setId(id);
        exercicioEntity.setNomeExercicio(exercicioDto.nome());
        exercicioEntity.setDescricao(exercicioDto.descricao());
        exercicioEntity.setImage(exercicioDto.image());

        exercicioRepository.save(exercicioEntity);
    }

    public void deleteExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
