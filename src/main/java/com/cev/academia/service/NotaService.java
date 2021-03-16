package com.cev.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.academia.domain.Nota;
import com.cev.academia.repositories.NotaRepository;

@Service
public class NotaService {
	@Autowired
	private NotaRepository notaRepository;
	
	public Nota postNota(Nota nota) {
		return notaRepository.save(nota);
	}
}
