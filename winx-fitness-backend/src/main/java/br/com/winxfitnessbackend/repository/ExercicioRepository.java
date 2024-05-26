package br.com.winxfitnessbackend.repository;

import br.com.winxfitnessbackend.entity.ExercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, Long> {

}
