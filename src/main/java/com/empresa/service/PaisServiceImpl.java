package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Deporte;
import com.empresa.entity.Pais;
import com.empresa.repository.DeporteRepository;
import com.empresa.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{
	@Autowired /*Hacer new al Service*/
	private PaisRepository repository;
	
	@Override
	public List<Pais> listaPais(){
		return repository.findAll();
	}
}
