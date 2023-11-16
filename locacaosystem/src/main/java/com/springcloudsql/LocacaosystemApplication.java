package com.springcloudsql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.springcloudsql.model.Cliente;
import com.springcloudsql.model.Equipamento;
import com.springcloudsql.repository.ClienteRepository;
import com.springcloudsql.repository.EquipamentoRepository;

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
		};
	}

}
