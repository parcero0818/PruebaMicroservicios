package com.capacitacion.Prueba;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capacitacion.Prueba.repository.Pais;

@Service
public class PaisServiceImpl implements PaisService{

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public Iterable<Pais> listPais() {
		return paisRepository.findAll();
	}

	
	public Pais getPaisById(Integer id) {
		return paisRepository.findOne(id);
	}
	
	public Pais addPais(Pais pais){
		return paisRepository.save(pais);
	}
	
	public void deletePais(Integer id) throws Exception{
		paisRepository.delete(id);
	}
}
