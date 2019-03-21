package com.marceloalves.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marceloalves.cursomc.domain.Categoria;
import com.marceloalves.cursomc.domain.Cidade;
import com.marceloalves.cursomc.domain.Cliente;
import com.marceloalves.cursomc.domain.Endereco;
import com.marceloalves.cursomc.domain.Estado;
import com.marceloalves.cursomc.domain.Pagamento;
import com.marceloalves.cursomc.domain.PagamentoComBoleto;
import com.marceloalves.cursomc.domain.PagamentoComCartao;
import com.marceloalves.cursomc.domain.Pedido;
import com.marceloalves.cursomc.domain.Produto;
import com.marceloalves.cursomc.domain.enums.EstadoPagamento;
import com.marceloalves.cursomc.domain.enums.TipoCliente;
import com.marceloalves.cursomc.repositoreis.CategoriaRepositoy;
import com.marceloalves.cursomc.repositoreis.CidadeRepositoy;
import com.marceloalves.cursomc.repositoreis.ClienteRepositoy;
import com.marceloalves.cursomc.repositoreis.EnderecoRepositoy;
import com.marceloalves.cursomc.repositoreis.EstadoRepositoy;
import com.marceloalves.cursomc.repositoreis.PagamentoRepositoy;
import com.marceloalves.cursomc.repositoreis.PedidoRepositoy;
import com.marceloalves.cursomc.repositoreis.ProdutoRepositoy;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepositoy categoriaRepository;
	@Autowired
	ProdutoRepositoy produtoRepositoy;
	@Autowired
	CidadeRepositoy cidadeRepositoy;
	@Autowired
	EstadoRepositoy estadoRepositoy;
	@Autowired
	EnderecoRepositoy enderecoRepositoy;
	@Autowired
	ClienteRepositoy clienteRepositoy;
	@Autowired
	PagamentoRepositoy pagamentoRepositoy;
	@Autowired
	PedidoRepositoy pedidoRepositoy;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepositoy.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepositoy.saveAll(Arrays.asList(est1, est2));
		cidadeRepositoy.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("67 3318-4444", "67 3318-5555"));
		Endereco e1 = new Endereco(null, "Rua Flores", "1000", "casa 1", "Rita Veira", "79000-100", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua tavares", "2000", "casa 2", "Lapa", "79000-100", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepositoy.saveAll(Arrays.asList(cli1));
		enderecoRepositoy.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepositoy.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepositoy.saveAll(Arrays.asList(pag1, pag2));
		
		

	}

}
