package com.todo.list.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.list.entity.listaEntity;
import com.todo.list.repositories.listaRepository;

@Service
public class listaService {
	@Autowired
	listaRepository listaRepository;

	public ArrayList<listaEntity> obtenerLista() {
		return (ArrayList<listaEntity>) listaRepository.findAll();
	}

	public listaEntity buscar(int id) {
		return listaRepository.findById(id).get();

	}

	public listaEntity guardar(listaEntity lista) {
		return listaRepository.save(lista);
	}

	public void actualizar(int id, listaEntity listaEntity) {
		listaEntity lista = listaRepository.findById(id).get();
		lista.setNombre(listaEntity.getNombre());
		lista.setDescripcion(listaEntity.getDescripcion());
		listaRepository.save(lista);
	}
	
	public void eliminar(int id) {
		listaRepository.deleteById(id);
	}

}
