package com.todo.list.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.list.entity.listaEntity;
import com.todo.list.services.listaService;

@RestController
@RequestMapping("/lista")
public class listaController {
	@Autowired
	listaService listaService;

	@GetMapping(path = "")
	public ArrayList<listaEntity> obtenerLista() {
		return listaService.obtenerLista();
	}

	@GetMapping(path = "/{id}")
	public listaEntity buscar(@PathVariable int id) {
		return listaService.buscar(id);
	}

	@PostMapping(path = "")
	public ResponseEntity<String> guardar(@RequestBody listaEntity listaModel) {
		listaService.guardar(listaModel);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> actualizar(@PathVariable int id, @RequestBody listaEntity listaEntity) {
		listaService.actualizar(id, listaEntity);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable int id) {
		listaService.eliminar(id);
		
	}

}
