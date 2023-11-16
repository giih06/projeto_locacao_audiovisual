-- Criação das minhas tabelas serão aqui --
-- Sistema Locação de equipamentos de audiovisual --
CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    endereco_id INT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    cep VARCHAR(10) NOT NULL
    FOREIGN KEY (endereco_id) REFERENCES enderecos(endereco_id);
)

CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    senha VARCHAR(255) NOT NULL
    cliente BOOLEAN NOT NULL DEFAULT FALSE
)

CREATE TABLE locacao (
    locacao_id SERIAL NOT NULL PRIMARY KEY,
    cliente_id INT NOT NULL,
    data_locacao TIMESTAMP NOT NULL DEFAULT now(),
    data_devolucao_prevista TIMESTAMP NOT NULL DEFAULT now(),
    valor_total DECIMAL(10,2),
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
)

CREATE TABLE equipamentos (
    equipamento_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) UNIQUE NOT NULL,
    descricao TEXT,
    preco_diario DECIMAL(10,2) NOT NULL,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
)

CREATE TABLE Reserva (
    reserva_id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    equipamento_id INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    status_reserva VARCHAR(20) NOT NULL,
    CHECK (status_reserva IN('pendente', 'confirmado', 'cancelado')),
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id),
    FOREIGN KEY (equipamento_id) REFERENCES equipamentos(equipamento_id)
)

CREATE TABLE enderecos {
    endereco_id SERIAL PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    complemento TEXT
}
