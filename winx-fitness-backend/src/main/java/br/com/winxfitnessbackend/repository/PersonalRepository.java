package br.com.winxfitnessbackend.repository;

import br.com.winxfitnessbackend.entity.PersonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<PersonalEntity, Long> {

}
