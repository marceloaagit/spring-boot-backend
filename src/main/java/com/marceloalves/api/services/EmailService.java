package com.marceloalves.api.services;

import org.springframework.mail.SimpleMailMessage;

import com.marceloalves.api.entities.Pedido;

public interface EmailService {

	void sendOrderConfimationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
}
