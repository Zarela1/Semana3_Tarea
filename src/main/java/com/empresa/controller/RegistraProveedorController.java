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

import com.empresa.entity.Modalidad;
import com.empresa.entity.Pais;
import com.empresa.entity.Proveedor;
import com.empresa.entity.Tipo;
import com.empresa.service.PaisService;
import com.empresa.service.ProveedorService;
import com.empresa.service.TipoService;

@Controller
public class RegistraProveedorController {

	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping(value = "/verRegistraProveedor" )
	public String verProveedor() {return "registraProveedor";}
	
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
	
	@PostMapping("/registraProveedor")
	@ResponseBody
	public Map<?, ?> registra(Proveedor obj){
		HashMap<String, String> map = new HashMap<String, String>();
		Proveedor objSalida = proveedorService.insertaProveedor(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		}else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	@GetMapping("/buscaPorNombreProveedor")
	@ResponseBody
	public String validaNombre(String nombre) {
		List<Proveedor> listaProveedorNombre = proveedorService.listaPorNombre(nombre);
		if (CollectionUtils.isEmpty(listaProveedorNombre)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}
	
	@GetMapping("/buscaPorDniProveedor")
	@ResponseBody
	public String validaDni(String dni) {
		List<Proveedor> listaProveedorDni = proveedorService.listaPorDni(dni);
		if (CollectionUtils.isEmpty(listaProveedorDni)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}
}
