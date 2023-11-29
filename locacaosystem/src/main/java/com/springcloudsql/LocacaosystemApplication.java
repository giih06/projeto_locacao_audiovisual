package com.springcloudsql;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springcloudsql.controller.ClienteController;
import com.springcloudsql.controller.EnderecoController;
import com.springcloudsql.controller.EquipamentoController;
import com.springcloudsql.controller.LocacaoController;
import com.springcloudsql.controller.ReservaController;
import com.springcloudsql.controller.UsuarioController;
import com.springcloudsql.model.Cliente;
import com.springcloudsql.model.Endereco;
import com.springcloudsql.model.Equipamento;
import com.springcloudsql.model.Locacao;
import com.springcloudsql.model.Reserva;
import com.springcloudsql.model.Usuario;
import com.springcloudsql.repository.ClienteRepository;
import com.springcloudsql.repository.EnderecoRepository;
import com.springcloudsql.repository.EquipamentoRepository;
import com.springcloudsql.repository.LocacaoRepository;
import com.springcloudsql.repository.ReservaRepository;
import com.springcloudsql.repository.UsuarioRepository;

@SpringBootApplication
public class LocacaosystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacaosystemApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository,EquipamentoRepository equipamentoRepository, EquipamentoController equipamentoController, LocacaoRepository locacaoRepository,LocacaoController locacaoController ,ClienteController clienteController, ReservaRepository reservaRepository, ReservaController reservaController, EnderecoRepository enderecoRepository, EnderecoController enderecoController, UsuarioRepository usuarioRepository, UsuarioController usuarioController) {
		return args -> {
			// limpando os dados existentes
			clienteRepository.deleteAll();
			equipamentoRepository.deleteAll();
			locacaoRepository.deleteAll();
			reservaRepository.deleteAll(); 
			usuarioRepository.deleteAll(); 
			enderecoRepository.deleteAll();
			/* 
			Cliente cliente1 = new Cliente();
			cliente1.setNome("Jullia Gomes");
			cliente1.setEmail("juliagomes@gmail.com");
			cliente1.setTelefone("71 998112312");
			clienteController.create(cliente1);
			
			Equipamento equipamento1 = new Equipamento();
			equipamento1.setNome("Câmera Profissional 4k");
			equipamento1.setDescricao("Uma câmera de vídeo avançada que grava em resolução 4K, oferecendo vídeos detalhados e de alta qualidade.a");
			equipamento1.setPrecoDiario(250.00);
			equipamento1.setDisponivel(false);
			equipamentoController.create(equipamento1);

			Endereco endereco1 = new Endereco();
			endereco1.setRua("Rua Pilha Freireza");
			endereco1.setNumero(181);
			endereco1.setCidade("Fortaleza");
			endereco1.setCep("8172-28391");
			endereco1.setComplemento("Perto da praça");
			enderecoController.create(endereco1);
			
			Usuario usuario1 = new Usuario();
			usuario1.setNome(cliente1.getNome());
			usuario1.setEmail(cliente1.getEmail());
			usuario1.setSenha("@kadjASD");
			usuarioController.create(usuario1);
			*/

			Equipamento equipamento2 = new Equipamento();
			equipamento2.setNome("Microfone sem fio");
			equipamento2.setDescricao("Um microfone portátil e sem cabos, ideal para apresentações e performances sem restrições de movimento");
			equipamento2.setPrecoDiario(60.00);
			equipamento2.setDisponivel(true);
			equipamentoController.create(equipamento2);

			Endereco endereco2 = new Endereco();
			endereco2.setRua("Rua Monique Gusta");
			endereco2.setNumero(900);
			endereco2.setCidade("Salvador");
			endereco2.setCep("98273-122");
			endereco2.setComplemento("Do lado do açai");
			enderecoController.create(endereco2);

			Usuario usuario2 = new Usuario();
			usuario2.setEmail("user2@gmail.com");
			usuario2.setNome("Kilakk");
			usuario2.setSenha("91KAad");
			usuarioController.create(usuario2);

			Cliente cliente2 = new Cliente();
			cliente2.setNome("Reinaldo Fernandes");
			cliente2.setEmail("reifernandes@gmail.com");
			cliente2.setTelefone("71 991666252");
			cliente2.setUsuario(usuario2);
			cliente2.setEndereco(endereco2);
			clienteController.create(cliente2);

			Locacao locacao1 = new Locacao();
			locacao1.setData_locacao(LocalDate.parse("2023-07-21"));
			locacao1.setData_devolucao_prevista(LocalDate.parse("2023-07-23"));
			locacao1.setValorTotal(203.99);
			locacao1.setCliente(cliente2);
			locacaoController.create(locacao1);

			Reserva reserva1 = new Reserva();
			reserva1.setData_inicio(LocalDate.parse("2023-07-23"));
			reserva1.setData_fim(LocalDate.parse("2023-07-26"));
			reserva1.setEquipamento(equipamento2);
			reserva1.setStatus("cancelado");
			reservaController.create(reserva1);

			Scanner sc = new Scanner(System.in);

			boolean decisao = true;
			int escolha, escolhaMenu;
			while (decisao) {
				System.out.println("Menu:");
				System.out.println("1 - Clientes");
				System.out.println("2 - Equipamentos");
				System.out.println("3 - Locacoes");
				System.out.println("4 - Reservas");
				System.out.println("5 - Endereços");
				System.out.println("6 - Usuários");
				System.out.println("0 - Sair");

				escolhaMenu = sc.nextInt();
				sc.nextLine();
				long idAtuaizacao, idExclusao;
				if(escolhaMenu == 1) {
					System.out.println("1 - Inserir cliente");
					System.out.println("2 - exibir clientes");
					System.out.println("3 - atualizar cliente");
					System.out.println("4 - excluir cliente");
					System.out.println("5 - voltar");
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

						clienteController.create(novoCliente);

						
						System.out.println("Cliente inserido com sucesso!");
					} else if (escolha == 2) { // exibe
						List<Cliente> clientes = clienteController.findAll();
						if(clientes.isEmpty()) {
							System.out.println("Nenhum cliente cadastrado");
						} else {
							System.out.println("Clientes cadastrados:");
							for(Cliente cliente : clientes) {
								System.out.println(cliente);
							}
						}
					} else if (escolha == 3) { // atualiza
						System.out.println("Digite o ID do cliente a ser atualizado:");
						idAtuaizacao = sc.nextLong();
						sc.nextLine(); // limpar o buffer
						Cliente clienteAtualizacao =  new Cliente();
						System.out.println("Digite o novo nome do cliente:");
						clienteAtualizacao.setNome(sc.nextLine());
						System.out.println("Digite o novo email do cliente:");
						clienteAtualizacao.setEmail(sc.nextLine());
						System.out.println("Digite o novo telefone do cliente:");
						clienteAtualizacao.setTelefone(sc.nextLine());
						clienteController.update(idAtuaizacao, clienteAtualizacao);
						System.out.println("Cliente atualizado com sucesso!");
					} else if (escolha == 4) { // delete
						System.out.println("Digite o ID do cliente a ser excluido");
						idExclusao = sc.nextLong();
						clienteController.delete(idExclusao);
						System.out.println("Cliente deletado com sucesso");
					} else if (escolha == 5) {
					} else {
						System.out.println("Opção inválida, tente novamente!");
					}
				} else if (escolhaMenu == 2) {
					System.out.println("1 - Inserir equipamento");
					System.out.println("2 - exibir equipamento");
					System.out.println("3 - atualizar equipamento");
					System.out.println("4 - excluir equipamento");
					System.out.println("5 - voltar");
					System.out.println("0 - Sair");
					escolha = sc.nextInt();
					sc.nextLine();
					if (escolha == 0) {
						System.out.println("Saindo...");
						decisao = false;
					} else if (escolha == 1) { // cria
						Equipamento novoEquipamento = new Equipamento();
						System.out.println("Digite o nome do equipamento:");
						novoEquipamento.setNome(sc.nextLine());

						System.out.println("Digite a descrição do equipamento:");
						novoEquipamento.setDescricao(sc.nextLine());

						System.out.println("Digite o preço diáro do equipamento:");
						novoEquipamento.setPrecoDiario(sc.nextDouble());

						System.out.println("O equipamento está disponível? responda com true ou false");
						novoEquipamento.setDisponivel(sc.nextBoolean());

						equipamentoController.create(novoEquipamento);
						
						System.out.println("Equipamento inserido com sucesso!");
					} else if (escolha == 2) { // exibe
						List<Equipamento> equipamentos = equipamentoController.findAll();
						if(equipamentos.isEmpty()) {
							System.out.println("Nenhum equipamento cadastrado");
						} else {
							System.out.println("Equipamentos cadastrados:");
							for(Equipamento equipamento : equipamentos) {
								System.out.println(equipamento); 
							}
						}
					} else if (escolha == 3) { // atualiza
						System.out.println("Digite o ID do equipamento a ser atualizado:");
						idAtuaizacao = sc.nextLong();
						sc.nextLine(); // limpar o buffer
						Equipamento equipamentoAtualizacao =  new Equipamento();
						System.out.println("Digite o novo nome do cliente:");
						equipamentoAtualizacao.setNome(sc.nextLine());
						System.out.println("Digite a nova descrição do equipamento:");
						equipamentoAtualizacao.setDescricao(sc.nextLine());
						System.out.println("Digite o novo preço Diário do equipamento:");
						equipamentoAtualizacao.setPrecoDiario(sc.nextDouble());
						System.out.println("Digite a nova disponibilidade do equipamento com true ou false:");
						equipamentoAtualizacao.setDisponivel(sc.nextBoolean());
						equipamentoController.update(idAtuaizacao, equipamentoAtualizacao);
						System.out.println("equipamento atualizado com sucesso!");
					} else if (escolha == 4) { // delete
						System.out.println("Digite o ID do equipamento a ser excluido");
						idExclusao = sc.nextLong();
						equipamentoController.delete(idExclusao);
						System.out.println("equipamento deletado com sucesso");
					} else if (escolha == 5) {

					} else {
						System.out.println("Opção inválida, tente novamente!");
					}
				} else if (escolhaMenu == 3) {

				}
			}
			sc.close();

		};
	}

}
