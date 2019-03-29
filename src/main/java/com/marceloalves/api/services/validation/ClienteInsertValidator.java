package com.marceloalves.api.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.marceloalves.api.controllers.exception.FieldMessage;
import com.marceloalves.api.dtos.ClienteNewDTO;
import com.marceloalves.api.entities.Cliente;
import com.marceloalves.api.entities.enums.TipoCliente;
import com.marceloalves.api.repositories.ClienteRepository;
import com.marceloalves.api.services.validation.utils.CpfOuCnjpValidUtil;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository clienteRepository;

	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

		
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())
				&& !CpfOuCnjpValidUtil.isValidCpf(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido!!!"));
		}

		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())
				&& !CpfOuCnjpValidUtil.isValidCnpj(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido!!!"));
		}
		
		Cliente clienteEmail = clienteRepository.findByEmail(objDto.getEmail());
		if(clienteEmail != null)
			list.add(new FieldMessage("email", "Email já cadastrado!!!"));

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
