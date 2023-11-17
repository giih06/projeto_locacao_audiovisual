package com.springcloudsql;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springcloudsql.controller.ClienteController;
import com.springcloudsql.model.Cliente;
import com.springcloudsql.repository.ClienteRepository;
import com.springcloudsql.repository.EquipamentoRepository;
import com.springcloudsql.repository.LocacaoRepository;

@SpringBootApplication
public class LocacaosystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacaosystemApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, EquipamentoRepository equipamentoRepository, LocacaoRepository locacaoRepository, ClienteController clienteController) {
		return args -> {
			// limpando os dados existentes
			clienteRepository.deleteAll();
			equipamentoRepository.deleteAll();
			locacaoRepository.deleteAll();
			
			Scanner sc = new Scanner(System.in);

			boolean decisao = true;
			int escolha;
			while (decisao) {
				System.out.println("Menu:");
				System.out.println("1 - Inserir cliente");
				System.out.println("2 - exibir clientes");
				System.out.println("3 - atualizar cliente");
				System.out.println("4 - excluir cliente");
				System.out.println("0 - Sair");

				escolha = sc.nextInt();
				sc.nextLine();
				if (escolha == 0) {
					System.out.println("Saindo...");
					decisao = false;
				} else if (escolha == 1) { // cria
					Cliente novoCliente = new Cliente();
					System.out.println("Digite o nome do cliente:");
					novoCliente.setNome(sc.nextLine());

					System.out.println("Digite o email do cliente:");
					novoCliente.setEmail(sc.nextLine());

					System.out.println("Digite o telefone do cliente:");
					novoCliente.setTelefone(sc.nextLine());

					System.out.println("Digite o cep do cliente:");
					novoCliente.setCep(sc.nextLine());

					clienteController.create(novoCliente);

					
					System.out.println("Cliente inserido com sucesso!");
				} else if (escolha == 2) { // exibe
					List<Cliente> clientes = clienteController.findAll();
					if(clientes.isEmpty()) {
						System.out.println("Nenhum cliente cadastrado");
					} else {
						System.out.println("Clientes cadastrados:");
						for(Cliente cliente : clientes) {
							System.out.println(cliente); // se não der certo, tentar o toString
						}
					}
				} else if (escolha == 3) { // atualiza
					System.out.println("Digite o ID do cliente a ser atualizado:");
					long idAtuaizacao = sc.nextLong();
					sc.nextLine(); // limpar o buffer
					Cliente clienteAtualizacao =  new Cliente();
					System.out.println("Digite o novo nome do cliente:");
					clienteAtualizacao.setNome(sc.nextLine());
					System.out.println("Digite o novo email do cliente:");
					clienteAtualizacao.setEmail(sc.nextLine());
					System.out.println("Digite o novo telefone do cliente:");
					clienteAtualizacao.setTelefone(sc.nextLine());
					System.out.println("Digite o novo cep do cliente:");
					clienteAtualizacao.setCep(sc.nextLine());
					clienteController.update(idAtuaizacao, clienteAtualizacao);
					System.out.println("Cliente atualizado com sucesso!");
				} else if (escolha == 4) { // delete
					System.out.println("Digite o ID do cliente a ser excluido");
					long idExclusao = sc.nextLong();
					clienteController.delete(idExclusao);
					System.out.println("Cliente deletado com sucesso");
				} else {
					System.out.println("Opção inválida, tente novamente!");
				}
			}
			sc.close();

		};
	}

}
