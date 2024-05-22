package br.com.winxfitnessbackend.repository;

import br.com.winxfitnessbackend.entity.ExercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, Long> {

}
