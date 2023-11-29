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

			Cliente cliente1 = new Cliente();
			cliente1.setNome("Jullia Gomes");
			cliente1.setEmail("juliagomes@gmail.com");
			cliente1.setTelefone("71 998112312");
			clienteController.create(cliente1);

			Cliente cliente2 = new Cliente();
			cliente2.setNome("Reinaldo Fernandes");
			cliente2.setEmail("reifernandes@gmail.com");
			cliente2.setTelefone("71 991666252");
			clienteController.create(cliente2);

			Cliente cliente3 = new Cliente();
			cliente3.setNome("Amanda Silva");
			cliente3.setEmail("amandasilva@gmail.com");
			cliente3.setTelefone("71 987654321");
			clienteController.create(cliente3);

			Cliente cliente4 = new Cliente();
			cliente4.setNome("Lucas Oliveira");
			cliente4.setEmail("lucasoliveira@gmail.com");
			cliente4.setTelefone("71 955555555");
			clienteController.create(cliente4);

			Cliente cliente5 = new Cliente();
			cliente5.setNome("Gabriela Santos");
			cliente5.setEmail("gabrielasantos@gmail.com");
			cliente5.setTelefone("71 933333333");
			clienteController.create(cliente5);

			Cliente cliente6 = new Cliente();
			cliente6.setNome("Rafaela Lima");
			cliente6.setEmail("rafaelalima@gmail.com");
			cliente6.setTelefone("71 922222222");
			clienteController.create(cliente6);

			Cliente cliente7 = new Cliente();
			cliente7.setNome("Anderson Pereira");
			cliente7.setEmail("andersonpereira@gmail.com");
			cliente7.setTelefone("71 911111111");
			clienteController.create(cliente7);

			Cliente cliente8 = new Cliente();
			cliente8.setNome("Fernanda Souza");
			cliente8.setEmail("fernandasouza@gmail.com");
			cliente8.setTelefone("71 900000000");
			clienteController.create(cliente8);

			Cliente cliente9 = new Cliente();
			cliente9.setNome("Thiago Santos");
			cliente9.setEmail("thiagosantos@gmail.com");
			cliente9.setTelefone("71 988888888");
			clienteController.create(cliente9);

			Cliente cliente10 = new Cliente();
			cliente10.setNome("Carla Oliveira");
			cliente10.setEmail("carlaoliveira@gmail.com");
			cliente10.setTelefone("71 977777777");
			clienteController.create(cliente10);

			Equipamento equipamento1 = new Equipamento();
			equipamento1.setNome("Câmera Profissional 4k");
			equipamento1.setDescricao("Uma câmera de vídeo avançada que grava em resolução 4K, oferecendo vídeos detalhados e de alta qualidade.a");
			equipamento1.setPrecoDiario(250.00);
			equipamento1.setDisponivel(false);
			equipamentoController.create(equipamento1);

			Equipamento equipamento2 = new Equipamento();
			equipamento2.setNome("Microfone sem fio");
			equipamento2.setDescricao("Um microfone portátil e sem cabos, ideal para apresentações e performances sem restrições de movimento");
			equipamento2.setPrecoDiario(60.00);
			equipamento2.setDisponivel(true);
			equipamentoController.create(equipamento2);

			Equipamento equipamento3 = new Equipamento();
			equipamento3.setNome("Lente Canon EF 24-70mm f/2.8L II USM");
			equipamento3.setDescricao("Uma lente profissional com abertura rápida, ideal para fotografias nítidas e de alta qualidade.");
			equipamento3.setPrecoDiario(80.00);
			equipamento3.setDisponivel(true);
			equipamentoController.create(equipamento3);

			Equipamento equipamento4 = new Equipamento();
			equipamento4.setNome("Tripé Manfrotto MT055XPRO3");
			equipamento4.setDescricao("Um tripé resistente e versátil, adequado para fotografia e videografia profissional.");
			equipamento4.setPrecoDiario(30.00);
			equipamento4.setDisponivel(false);
			equipamentoController.create(equipamento4);

			Equipamento equipamento5 = new Equipamento();
			equipamento5.setNome("Microfone Rode NT-USB");
			equipamento5.setDescricao("Um microfone USB de alta qualidade para gravação de áudio profissional em computadores e dispositivos móveis.");
			equipamento5.setPrecoDiario(40.00);
			equipamento5.setDisponivel(true);
			equipamentoController.create(equipamento5);

			Equipamento equipamento6 = new Equipamento();
			equipamento6.setNome("GoPro HERO9 Black");
			equipamento6.setDescricao("Uma câmera de ação poderosa com capacidade de gravação em 5K e recursos avançados de estabilização.");
			equipamento6.setPrecoDiario(120.00);
			equipamento6.setDisponivel(false);
			equipamentoController.create(equipamento6);

			Equipamento equipamento7 = new Equipamento();
			equipamento7.setNome("Monitor Dell UltraSharp U2719D");
			equipamento7.setDescricao("Um monitor de alta resolução e cores precisas, ideal para design gráfico e edição de vídeo.");
			equipamento7.setPrecoDiario(60.00);
			equipamento7.setDisponivel(true);
			equipamentoController.create(equipamento7);

			Equipamento equipamento8 = new Equipamento();
			equipamento8.setNome("Teclado Mecânico Corsair K95 RGB Platinum XT");
			equipamento8.setDescricao("Um teclado mecânico premium com iluminação RGB personalizável e switches Cherry MX.");
			equipamento8.setPrecoDiario(25.00);
			equipamento8.setDisponivel(true);
			equipamentoController.create(equipamento8);

			Equipamento equipamento9 = new Equipamento();
			equipamento9.setNome("Projetor Epson Home Cinema 5050UB");
			equipamento9.setDescricao("Um projetor 4K com tecnologia de imagem avançada, proporcionando uma experiência cinematográfica em casa.");
			equipamento9.setPrecoDiario(200.00);
			equipamento9.setDisponivel(false);
			equipamentoController.create(equipamento9);

			Equipamento equipamento10 = new Equipamento();
			equipamento10.setNome("Tablet Apple iPad Pro");
			equipamento10.setDescricao("Um tablet potente com tela Liquid Retina, processador A14 Bionic e suporte ao Apple Pencil.");
			equipamento10.setPrecoDiario(70.00);
			equipamento10.setDisponivel(true);
			equipamentoController.create(equipamento10);

			Endereco endereco1 = new Endereco();
			endereco1.setRua("Rua Pilha Freireza");
			endereco1.setNumero(181);
			endereco1.setCidade("Fortaleza");
			endereco1.setCep("8172-28391");
			endereco1.setComplemento("Perto da praça");
			enderecoController.create(endereco1);
			
			Endereco endereco2 = new Endereco();
			endereco2.setRua("Rua Monique Gusta");
			endereco2.setNumero(900);
			endereco2.setCidade("Salvador");
			endereco2.setCep("98273-122");
			endereco2.setComplemento("Do lado do açai");
			enderecoController.create(endereco2);


			Endereco endereco3 = new Endereco();
			endereco3.setRua("Avenida dos Bandeirantes");
			endereco3.setNumero(555);
			endereco3.setCidade("São Paulo");
			endereco3.setCep("04534-098");
			endereco3.setComplemento("Próximo ao metrô");
			enderecoController.create(endereco3);
			
			Endereco endereco4 = new Endereco();
			endereco4.setRua("Rua das Palmeiras");
			endereco4.setNumero(123);
			endereco4.setCidade("Rio de Janeiro");
			endereco4.setCep("20020-010");
			endereco4.setComplemento("Frente ao parque");
			enderecoController.create(endereco4);
			
			Endereco endereco5 = new Endereco();
			endereco5.setRua("Avenida Beira Mar");
			endereco5.setNumero(789);
			endereco5.setCidade("Recife");
			endereco5.setCep("50030-000");
			endereco5.setComplemento("Vista para o mar");
			enderecoController.create(endereco5);
			
			Endereco endereco6 = new Endereco();
			endereco6.setRua("Rua das Flores");
			endereco6.setNumero(456);
			endereco6.setCidade("Curitiba");
			endereco6.setCep("80010-050");
			endereco6.setComplemento("Próximo ao shopping");
			enderecoController.create(endereco6);
			
			Endereco endereco7 = new Endereco();
			endereco7.setRua("Avenida Paulista");
			endereco7.setNumero(987);
			endereco7.setCidade("São Paulo");
			endereco7.setCep("01311-000");
			endereco7.setComplemento("Centro financeiro");
			enderecoController.create(endereco7);
			
			Endereco endereco8 = new Endereco();
			endereco8.setRua("Rua das Gaivotas");
			endereco8.setNumero(321);
			endereco8.setCidade("Florianópolis");
			endereco8.setCep("88040-090");
			endereco8.setComplemento("Perto da lagoa");
			enderecoController.create(endereco8);
			
			Endereco endereco9 = new Endereco();
			endereco9.setRua("Avenida do Sol");
			endereco9.setNumero(654);
			endereco9.setCidade("Natal");
			endereco9.setCep("59020-160");
			endereco9.setComplemento("Bairro residencial");
			enderecoController.create(endereco9);
			
			Endereco endereco10 = new Endereco();
			endereco10.setRua("Rua dos Coqueiros");
			endereco10.setNumero(222);
			endereco10.setCidade("Fortaleza");
			endereco10.setCep("60123-456");
			endereco10.setComplemento("Próximo à escola");
			enderecoController.create(endereco10);			

			Usuario usuario1 = new Usuario();
			usuario1.setNome(cliente1.getNome());
			usuario1.setEmail(cliente1.getEmail());
			usuario1.setSenha("@kadjASD");
			usuarioController.create(usuario1);

			Usuario usuario2 = new Usuario();
			usuario2.setEmail("user2@gmail.com");
			usuario2.setNome("Kilakk");
			usuario2.setSenha("91KAad");
			usuarioController.create(usuario2);

			Usuario usuario3 = new Usuario();
			usuario3.setEmail("usuario3@gmail.com");
			usuario3.setNome("Leticia");
			usuario3.setSenha("Leticia@123");
			usuarioController.create(usuario3);
			
			Usuario usuario4 = new Usuario();
			usuario4.setEmail("usuario4@gmail.com");
			usuario4.setNome("JoaoP");
			usuario4.setSenha("P@ssw0rd");
			usuarioController.create(usuario4);
			
			Usuario usuario5 = new Usuario();
			usuario5.setEmail("usuario5@gmail.com");
			usuario5.setNome("CarolinaS");
			usuario5.setSenha("CarolinaPass");
			usuarioController.create(usuario5);
			
			Usuario usuario6 = new Usuario();
			usuario6.setEmail("usuario6@gmail.com");
			usuario6.setNome("MarceloT");
			usuario6.setSenha("Tiger123");
			usuarioController.create(usuario6);
			
			Usuario usuario7 = new Usuario();
			usuario7.setEmail("usuario7@gmail.com");
			usuario7.setNome("CamilaF");
			usuario7.setSenha("Camila@567");
			usuarioController.create(usuario7);
			
			Usuario usuario8 = new Usuario();
			usuario8.setEmail("usuario8@gmail.com");
			usuario8.setNome("AndreM");
			usuario8.setSenha("Mypass123");
			usuarioController.create(usuario8);
			
			Usuario usuario9 = new Usuario();
			usuario9.setEmail("usuario9@gmail.com");
			usuario9.setNome("JulianoR");
			usuario9.setSenha("Rocks123");
			usuarioController.create(usuario9);
			
			Usuario usuario10 = new Usuario();
			usuario10.setEmail("usuario10@gmail.com");
			usuario10.setNome("PatriciaC");
			usuario10.setSenha("PatC@789");
			usuarioController.create(usuario10);			

			Locacao locacao1 = new Locacao();
			locacao1.setData_locacao(LocalDate.parse("2023-07-21"));
			locacao1.setData_devolucao_prevista(LocalDate.parse("2023-07-23"));
			locacao1.setValorTotal(203.99);
			locacaoController.create(locacao1);

			Locacao locacao2 = new Locacao();
			locacao2.setData_locacao(LocalDate.parse("2023-08-05"));
			locacao2.setData_devolucao_prevista(LocalDate.parse("2023-08-08"));
			locacao2.setValorTotal(150.50);
			locacaoController.create(locacao2);
			
			Locacao locacao3 = new Locacao();
			locacao3.setData_locacao(LocalDate.parse("2023-09-10"));
			locacao3.setData_devolucao_prevista(LocalDate.parse("2023-09-15"));
			locacao3.setValorTotal(300.00);
			locacaoController.create(locacao3);
			
			Locacao locacao4 = new Locacao();
			locacao4.setData_locacao(LocalDate.parse("2023-10-02"));
			locacao4.setData_devolucao_prevista(LocalDate.parse("2023-10-05"));
			locacao4.setValorTotal(120.75);
			locacaoController.create(locacao4);
			
			Locacao locacao5 = new Locacao();
			locacao5.setData_locacao(LocalDate.parse("2023-11-18"));
			locacao5.setData_devolucao_prevista(LocalDate.parse("2023-11-22"));
			locacao5.setValorTotal(180.25);
			locacaoController.create(locacao5);
			
			Locacao locacao6 = new Locacao();
			locacao6.setData_locacao(LocalDate.parse("2023-12-03"));
			locacao6.setData_devolucao_prevista(LocalDate.parse("2023-12-08"));
			locacao6.setValorTotal(250.00);
			locacaoController.create(locacao6);
			
			Locacao locacao7 = new Locacao();
			locacao7.setData_locacao(LocalDate.parse("2024-01-15"));
			locacao7.setData_devolucao_prevista(LocalDate.parse("2024-01-20"));
			locacao7.setValorTotal(175.50);
			locacaoController.create(locacao7);
			
			Locacao locacao8 = new Locacao();
			locacao8.setData_locacao(LocalDate.parse("2024-02-28"));
			locacao8.setData_devolucao_prevista(LocalDate.parse("2024-03-03"));
			locacao8.setValorTotal(90.80);
			locacaoController.create(locacao8);
			
			Locacao locacao9 = new Locacao();
			locacao9.setData_locacao(LocalDate.parse("2024-03-10"));
			locacao9.setData_devolucao_prevista(LocalDate.parse("2024-03-15"));
			locacao9.setValorTotal(200.00);
			locacaoController.create(locacao9);
			
			Locacao locacao10 = new Locacao();
			locacao10.setData_locacao(LocalDate.parse("2024-04-22"));
			locacao10.setData_devolucao_prevista(LocalDate.parse("2024-04-25"));
			locacao10.setValorTotal(130.99);
			locacaoController.create(locacao10);
			

			Reserva reserva1 = new Reserva();
			reserva1.setData_inicio(LocalDate.parse("2023-07-23"));
			reserva1.setData_fim(LocalDate.parse("2023-07-26"));
			reserva1.setStatus("cancelado");
			reservaController.create(reserva1);

			Reserva reserva2 = new Reserva();
			reserva2.setData_inicio(LocalDate.parse("2023-08-10"));
			reserva2.setData_fim(LocalDate.parse("2023-08-15"));
			reserva2.setStatus("pendente");
			reservaController.create(reserva2);
			
			Reserva reserva3 = new Reserva();
			reserva3.setData_inicio(LocalDate.parse("2023-09-05"));
			reserva3.setData_fim(LocalDate.parse("2023-09-10"));
			reserva3.setStatus("confirmado");
			reservaController.create(reserva3);
			
			Reserva reserva4 = new Reserva();
			reserva4.setData_inicio(LocalDate.parse("2023-10-20"));
			reserva4.setData_fim(LocalDate.parse("2023-10-25"));
			reserva4.setStatus("confirmado");
			reservaController.create(reserva4);
			
			Reserva reserva5 = new Reserva();
			reserva5.setData_inicio(LocalDate.parse("2023-11-15"));
			reserva5.setData_fim(LocalDate.parse("2023-11-20"));
			reserva5.setStatus("cancelado");
			reservaController.create(reserva5);
			
			Reserva reserva6 = new Reserva();
			reserva6.setData_inicio(LocalDate.parse("2023-12-05"));
			reserva6.setData_fim(LocalDate.parse("2023-12-10"));
			reserva6.setStatus("confirmado");
			reservaController.create(reserva6);
			
			Reserva reserva7 = new Reserva();
			reserva7.setData_inicio(LocalDate.parse("2024-01-25"));
			reserva7.setData_fim(LocalDate.parse("2024-01-30"));
			reserva7.setStatus("pendente");
			reservaController.create(reserva7);
			
			Reserva reserva8 = new Reserva();
			reserva8.setData_inicio(LocalDate.parse("2024-02-15"));
			reserva8.setData_fim(LocalDate.parse("2024-02-20"));
			reserva8.setStatus("confirmado");
			reservaController.create(reserva8);
			
			Reserva reserva9 = new Reserva();
			reserva9.setData_inicio(LocalDate.parse("2024-03-20"));
			reserva9.setData_fim(LocalDate.parse("2024-03-25"));
			reserva9.setStatus("cancelado");
			reservaController.create(reserva9);
			
			Reserva reserva10 = new Reserva();
			reserva10.setData_inicio(LocalDate.parse("2024-04-10"));
			reserva10.setData_fim(LocalDate.parse("2024-04-15"));
			reserva10.setStatus("pendente");
			reservaController.create(reserva10);
			

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
