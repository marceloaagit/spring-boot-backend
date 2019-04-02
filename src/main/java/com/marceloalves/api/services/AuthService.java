package com.marceloalves.api.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marceloalves.api.entities.Cliente;
import com.marceloalves.api.repositories.ClienteRepository;
import com.marceloalves.api.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private BCryptPasswordEncoder bc;
	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado!");
		}
		String newPass = newPassword();
		cliente.setSenha(bc.encode(newPass));
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) {
			return (char) (rand.nextInt(10) + 48); // gera um digito
		} else if (opt == 1) {
			return (char) (rand.nextInt(26) + 65); // gera letra maiúscula
		} else {
			return (char) (rand.nextInt(26) + 97); // gera letra minúscula
		}

	}

}
