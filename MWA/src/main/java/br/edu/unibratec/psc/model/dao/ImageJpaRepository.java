package br.edu.unibratec.psc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unibratec.psc.model.entity.ImageEntity;
import br.edu.unibratec.psc.model.entity.Pessoa;

@Repository
public interface ImageJpaRepository 
	extends JpaRepository<ImageEntity, Integer> {

}
