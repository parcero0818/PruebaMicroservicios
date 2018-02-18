package com.capacitacion.Prueba;

import com.capacitacion.Prueba.repository.Pais;

public interface PaisService {

	Iterable<Pais> listPais();
	
	Pais getPaisById(Integer id);
	
}
