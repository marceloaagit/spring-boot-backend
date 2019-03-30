package com.marceloalves.api.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.marceloalves.api.entities.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pgto.setDataPagamento(cal.getTime());
	}

}
