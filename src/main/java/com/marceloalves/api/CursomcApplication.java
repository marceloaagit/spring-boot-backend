package com.marceloalves.api;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marceloalves.api.entities.Categoria;
import com.marceloalves.api.entities.Cidade;
import com.marceloalves.api.entities.Cliente;
import com.marceloalves.api.entities.Endereco;
import com.marceloalves.api.entities.Estado;
import com.marceloalves.api.entities.ItemPedido;
import com.marceloalves.api.entities.Pagamento;
import com.marceloalves.api.entities.PagamentoComBoleto;
import com.marceloalves.api.entities.PagamentoComCartao;
import com.marceloalves.api.entities.Pedido;
import com.marceloalves.api.entities.Produto;
import com.marceloalves.api.entities.enums.EstadoPagamento;
import com.marceloalves.api.entities.enums.TipoCliente;
import com.marceloalves.api.repositories.CategoriaRepository;
import com.marceloalves.api.repositories.CidadeRepository;
import com.marceloalves.api.repositories.ClienteRepository;
import com.marceloalves.api.repositories.EnderecoRepository;
import com.marceloalves.api.repositories.EstadoRepository;
import com.marceloalves.api.repositories.ItemPedidoRepository;
import com.marceloalves.api.repositories.PagamentoRepository;
import com.marceloalves.api.repositories.PedidoRepository;
import com.marceloalves.api.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepositoy;
	@Autowired
	CidadeRepository cidadeRepositoy;
	@Autowired
	EstadoRepository estadoRepositoy;
	@Autowired
	EnderecoRepository enderecoRepositoy;
	@Autowired
	ClienteRepository clienteRepositoy;
	@Autowired
	PagamentoRepository pagamentoRepositoy;
	@Autowired
	PedidoRepository pedidoRepositoy;
	@Autowired
	ItemPedidoRepository itemPedidoRepositoy;
	

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
		
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2018 00:00"), null);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepositoy.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepositoy.saveAll(Arrays.asList(pag1, pag2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.0);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepositoy.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
