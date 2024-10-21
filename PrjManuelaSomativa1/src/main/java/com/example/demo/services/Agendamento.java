package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Agendamentos;
import com.example.demo.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	private final AgendamentoRepository agendamentorepository;

	@Autowired
	public AgendamentoService(AgendamentoRepository agendamentorepository) {
		this.agendamentorepository = agendamentorepository;
	}


	public Agendamento saveAgendamento(Agendamento agendamento) {
		return agendamentorepository.save(agendamento);
	}

	
	public Agendamento getAgendamentoById(Long id) {
		return agendamentorepository.findById(id).orElse(null);
	}

	
	public List<Agendamento> getAllAgendamento() {
		return agendamentorepository.findAll();
	}

	
	public void deleteAgendamento(Long id) {
		agendamentorepository.deleteById(id);
	}
}