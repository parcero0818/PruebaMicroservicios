package com.capacitacion.Prueba;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
    @PostMapping("/paises")
    public String paises(Model model) {
		System.out.println(model.toString());
		String paises = "";
		
		for (Pais paise : pais.listPais()) {
			paises += paise.getPa_nombre() +"\n";
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
	
	@RequestMapping("/pais")
    public Pais pais(@RequestParam("nombre") int nombre) {
		System.out.println("Nombre "+ nombre);
		Pais pais1 = pais.getPaisById(nombre);
		
        return pais1;
    }
    
    
//  @RequestMapping("/")
//  public String index() {
//      return "index";
//  }
}
