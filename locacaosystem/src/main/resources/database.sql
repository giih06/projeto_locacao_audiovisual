-- Criação das minhas tabelas serão aqui --
-- Sistema Locação de equipamentos de audiovisual --
CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(255),
    endereco_id BIGINT NOT NULL,
usuario_id BIGINT,
    FOREIGN KEY (endereco_id) REFERENCES enderecos(endereco_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)

CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
)

CREATE TABLE locacoes (
    id SERIAL NOT NULL PRIMARY KEY,
    data_locacao DATE NOT NULL DEFAULT now(),
    data_devolucao_prevista DATE NOT NULL,
    valor_total DECIMAL(10,2),
    cliente_id BIGINT NOT NULL,
    equipamento_id BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
    FOREIGN KEY (equipamento_id) REFERENCES equipamentos(id)
)

CREATE TABLE equipamentos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    preco_diario DECIMAL(10,2) NOT NULL,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
)

CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    equipamento_id INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    status_reserva VARCHAR(20) NOT NULL,
    cliente_id BIGINT NOT NULL,
    equipamento_id BIGINT NOT NULL,
    CHECK (status_reserva IN('pendente', 'confirmado', 'cancelado')),
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id),
    FOREIGN KEY (equipamento_id) REFERENCES equipamentos(equipamento_id)
)

CREATE TABLE enderecos {
    id SERIAL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    complemento VARCHAR(255)
}