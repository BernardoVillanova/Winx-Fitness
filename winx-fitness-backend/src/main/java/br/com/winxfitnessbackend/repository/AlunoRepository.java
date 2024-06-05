package br.com.winxfitnessbackend.repository;

import br.com.winxfitnessbackend.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    @Query(value = " SELECT id FROM AlunoEntity WHERE email = :email AND senha = :senha")
    Optional<Long> findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
