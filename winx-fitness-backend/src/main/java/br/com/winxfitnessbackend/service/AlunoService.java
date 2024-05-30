package br.com.winxfitnessbackend.service;

import br.com.winxfitnessbackend.dto.AlunoCadastroDto;
import br.com.winxfitnessbackend.dto.AlunoDto;
import br.com.winxfitnessbackend.entity.AlunoEntity;
import br.com.winxfitnessbackend.enums.FrequenciaAtividadeFisica;
import br.com.winxfitnessbackend.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDto> findAll() {
        List<AlunoDto> alunoDtoList = new ArrayList<>();

        for (AlunoEntity alunoEntity : alunoRepository.findAll()) {
            alunoDtoList.add(
                    new AlunoDto(
                            alunoEntity.getNome(), alunoEntity.getEmail(), BigDecimal.valueOf(alunoEntity.getPeso()), BigDecimal.valueOf(alunoEntity.getAltura()),
                            FrequenciaAtividadeFisica.getEnumById(alunoEntity.getSedentario())));
        }

        return alunoDtoList;
    }

    public void insereNovoAluno(AlunoCadastroDto alunoCadastroDto) {
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNome(alunoCadastroDto.nome());
        alunoEntity.setEmail(alunoCadastroDto.email());
        alunoEntity.setSenha(alunoCadastroDto.password());
        alunoEntity.setAltura(alunoCadastroDto.altura().setScale(2, RoundingMode.CEILING).floatValue());
        alunoEntity.setPeso(alunoCadastroDto.peso().setScale(2, RoundingMode.CEILING).floatValue());

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
