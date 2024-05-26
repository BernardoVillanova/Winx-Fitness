package br.com.winxfitnessbackend.service;

import br.com.winxfitnessbackend.enums.TipoUsuario;
import br.com.winxfitnessbackend.config.ManualAuth;
import br.com.winxfitnessbackend.dto.LoginDto;
import br.com.winxfitnessbackend.repository.AlunoRepository;
import br.com.winxfitnessbackend.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    PersonalRepository personalRepository;

    private Optional<Long> verificaLoginAluno(LoginDto loginDto) {
        return alunoRepository.findByNameAndSenha(loginDto.usuario(), loginDto.senha());
    }

    private Optional<Long> verificaLoginPersonal(LoginDto loginDto) {
        return personalRepository.findByNameAndSenha(loginDto.usuario(), loginDto.senha());
    }

    public String efetuarLogin(LoginDto loginDto) {
        String hash = "";

        if (loginDto.tipoUsuario() == TipoUsuario.ALUNO) {
            Optional<Long> idLogin = verificaLoginAluno(loginDto);
            if (idLogin.isPresent()) {
                hash = gerahash(loginDto);

                atualizaCacheManualAuth(hash, idLogin.get(), loginDto);
            }
        } else if (loginDto.tipoUsuario() == TipoUsuario.PERSONAL) {
            Optional<Long> idLogin = verificaLoginPersonal(loginDto);
            if (idLogin.isPresent()) {
                hash = gerahash(loginDto);

                atualizaCacheManualAuth(hash, idLogin.get(), loginDto);
            }
        }

        return hash;
    }

    private String gerahash(LoginDto loginDto) {
        return new StringBuilder()
                .append(loginDto.tipoUsuario().getDescricao().toLowerCase().replace("a", "zyx"))
                .append(loginDto.usuario().toLowerCase().replace("a", "12345"))
                .toString().trim();
    }

    private void atualizaCacheManualAuth(String hash, Long idUsuario, LoginDto loginDto) {
        List<String> dadosUsuario = new ArrayList<>();
        dadosUsuario.add(idUsuario.toString());
        dadosUsuario.add(loginDto.tipoUsuario().getDescricao());

        ManualAuth.mTokens.put(hash, dadosUsuario);
    }
}
