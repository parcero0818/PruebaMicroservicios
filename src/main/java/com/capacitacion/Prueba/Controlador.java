package com.capacitacion.Prueba;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capacitacion.Prueba.repository.Pais;

@RestController
public class Controlador {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private PaisServiceImpl pais;
	
//	@RequestMapping("/greeting")
//	public Saludo greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return new Saludo(counter.incrementAndGet(), String.format(template, name));
//	}
	
    
    /*
     * Para consumirlo por rest se selecciona POST, en body se selecciona raw y JSON application
     * 	{
	*		"pa_id": "1",
	*		"pa_nombre": "Colombia"
	*	}
     * */
    @PostMapping("/listapaises")
    public String listapaises(@RequestBody Pais paise) {
		System.out.println(paise.getPa_nombre());
		String paises = "";
		
		for (Pais listPais : pais.listPais()) {
			paises += listPais.getPa_nombre() +"\n";
		}
		
        return paises;
    }
    
    @PostMapping("/paisesNombre")
    public String paisPorNombre(@RequestParam String nombre) {
		System.out.println("Nombre "+nombre);
		String paises = "";
		
		for (Pais listPais : pais.listPais()) {
			paises += listPais.getPa_nombre() +"\n";
		}
		
        return paises;
    }
    
    
   /* @PostMapping("/paises")
    public String paises(Model model) {
		System.out.println(model.toString());
		String paises = "";
		
		for (Pais paise : pais.listPais()) {
			paises += paise.getPa_nombre() +"\n";
		}
		
        return paises;
    }*/
	
    /*Se envía solo el id*/
	@RequestMapping("/pais")
    public String paisPorId(@RequestBody int id) {
		System.out.println("Id "+ id);
		Pais pais1 = pais.getPaisById(id);
		
        return pais1.getPa_nombre();
    }
    
	
	@RequestMapping(value="/addPais", method = RequestMethod.POST)
	public Pais addPais(@RequestBody Pais paisRequest) {
		return pais.addPais(paisRequest);
	}
	
	@RequestMapping(value="/deletePais", method = RequestMethod.POST)
	public String deletePais(@RequestBody int idPais) {
		try {
			pais.deletePais(idPais);
			return "Exito";
		}catch(Exception ex){
			System.out.println("Exception "+ ex);
			return "Error";
		}
	}
}
