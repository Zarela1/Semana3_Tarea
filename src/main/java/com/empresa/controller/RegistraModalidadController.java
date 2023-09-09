package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Deporte;
import com.empresa.entity.Modalidad;
import com.empresa.entity.Pais;
import com.empresa.entity.Tipo;
import com.empresa.service.DeporteService;
import com.empresa.service.ModalidadService;
import com.empresa.service.PaisService;
import com.empresa.service.TipoService;

@Controller
public class RegistraModalidadController {
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private PaisService paisService;

	@Autowired
	private DeporteService deporteService;
	
	@Autowired
	private ModalidadService modalidadService;
		
	@GetMapping(value = "/verRegistraModalidad" )
	public String verModalidad() {return "registraModalidad";}
	
	@ResponseBody /*Retornar datos en JSON*/
	@GetMapping(value = "/listaTipo" )
	public List<Tipo> listaT(){
		return tipoService.listaTipo();
	}
	
	@ResponseBody /*Retornar datos en JSON*/
	@GetMapping(value = "/listaPais" )
	public List<Pais> listaP(){
		return paisService.listaPais();
	}
	
	@ResponseBody /*Retornar datos en JSON*/
	@GetMapping(value = "/listaDeporte" )
	public List<Deporte> lista(){
		return deporteService.listaDeporte();
	}
  
	
	
	@PostMapping("/registraModalidad")
	@ResponseBody
	public Map<?, ?> registra(Modalidad obj){
		HashMap<String, String> map = new HashMap<String, String>();
		Modalidad objSalida = modalidadService.insertaModalidad(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		}else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	@GetMapping("/buscaPorNombreModalidad")
	@ResponseBody
	public String validaNombre(String nombre) {
		List<Modalidad> lstModalidad = modalidadService.listaPorNombre(nombre);
		if (CollectionUtils.isEmpty(lstModalidad)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}
			
	
}







