package com.springcloudsql;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.springcloudsql.model.Cliente;
import com.springcloudsql.model.Equipamento;
import com.springcloudsql.model.Locacao;
import com.springcloudsql.repository.ClienteRepository;
import com.springcloudsql.repository.EquipamentoRepository;
import com.springcloudsql.repository.LocacaoRepository;

@SpringBootApplication
public class LocacaosystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacaosystemApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, EquipamentoRepository equipamentoRepository, LocacaoRepository locacaoRepository) {
		return args -> {
			// limpando os dados existentes
			clienteRepository.deleteAll();
			equipamentoRepository.deleteAll();
			locacaoRepository.deleteAll();
			
			
			Cliente c1 = new Cliente();
			c1.setNome("Andre");
			c1.setEmail("andrefagundes@gmail.com");
			c1.setTelefone("(71) 992556123");
			c1.setCep("6243-9162");
			clienteRepository.save(c1);
			
			Cliente c2 = new Cliente();
			c2.setNome("Maria Paula");
			c2.setEmail("mariapaula@gmail.com");
			c2.setTelefone("(71) 992336172");
			c2.setCep("1221-6432");
			clienteRepository.save(c2);

			Cliente c3 = new Cliente();
			c3.setNome("Juliano Andrade");
			c3.setEmail("julianoandrade@gmail.com");
			c3.setTelefone("(71) 99126253");
			c3.setCep("1341-7162");
			clienteRepository.save(c3);

			Equipamento e1 = new Equipamento();
			e1.setNome("Câmera Sony a3");
			e1.setDescricao("Vem com bateria");
			e1.setPrecoDiario(322.88);
			e1.setDisponivel(true);
			equipamentoRepository.save(e1);


			Equipamento e2 = new Equipamento();
			e2.setNome("Camera a3 Sony");
			e2.setDescricao("Vem com bateria");
			e2.setPrecoDiario(150.99);
			e2.setDisponivel(false);
			equipamentoRepository.save(e2);

			Equipamento e3 = new Equipamento();
			e3.setNome("Tripe Asure");
			e3.setDescricao("Não vem com adicional");
			e3.setPrecoDiario(400.23);
			e3.setDisponivel(false);
			equipamentoRepository.save(e3);

			Locacao l1 = new Locacao();
			l1.setData_locacao(LocalDate.parse("2023-07-20"));
			l1.setData_devolucao_prevista(LocalDate.parse("2023-07-20"));
			l1.setValorTotal(20028.99);
			locacaoRepository.save(l1);

			Locacao l2 = new Locacao();
			l2.setData_locacao(LocalDate.parse("2023-08-10"));
			l2.setData_devolucao_prevista(LocalDate.parse("2023-10-12"));
			l2.setValorTotal(399.99);
			locacaoRepository.save(l2);

			Locacao l3 = new Locacao();
			l3.setData_locacao(LocalDate.parse("2023-04-22"));
			l3.setData_devolucao_prevista(LocalDate.parse("2023-06-26"));
			l3.setValorTotal(123.99);
			locacaoRepository.save(l3);	
		};
	}

}
