package com.capacitacion.Prueba;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.capacitacion.Prueba.repository.Pais;

@Transactional
public interface PaisRepository extends CrudRepository<Pais, Integer>{
	

}
