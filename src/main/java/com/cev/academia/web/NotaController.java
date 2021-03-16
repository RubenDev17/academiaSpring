package com.cev.academia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cev.academia.domain.Nota;
import com.cev.academia.service.NotaService;

@RestController
public class NotaController {
	@Autowired
	private NotaService notaService;
	
	//Hacemos un post
	@PostMapping(path="notas")
	public Nota postNota(@RequestBody Nota nota) {
		return notaService.postNota(nota);
	}
}
