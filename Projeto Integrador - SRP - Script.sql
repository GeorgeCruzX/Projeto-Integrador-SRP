CREATE TABLE `Cidadão` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
    `cpf` char(11) NOT NULL,    
	`email` varchar(255) NOT NULL,
	`senha` varchar(500) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Reclamação` (
	`id` bigint NOT NULL AUTO_INCREMENT,
    `reclamar` varchar(1000) NOT NULL,
	`endereco` varchar(600) NOT NULL,
	`setor` varchar(45) NOT NULL,
	`enviar` varchar(500) NOT NULL,
	`cidadao_id` bigint NOT NULL,
	`setor_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Prefeitura` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`departamento_prefeitura` varchar(500) NOT NULL,
	PRIMARY KEY (`id`)
);

-- Inserindo dados na tabela Cidadão
INSERT INTO `Cidadão` (`nome`, `cpf`, `email`, `senha`) 
VALUES 
    ('João Silva', '12345678901', 'joao@email.com', 'senha123'),
    ('Maria Souza', '98765432109', 'maria@email.com', 'senha456');

-- Inserindo dados na tabela Prefeitura
INSERT INTO `Prefeitura` (`departamento_prefeitura`) 
VALUES 
    ('Departamento de Obras'),
    ('Departamento de Saúde');

-- Inserindo dados na tabela Reclamação
INSERT INTO `Reclamação` (`reclamar`, `endereco`, `setor`, `enviar`, `cidadao_id`, `setor_id`) 
VALUES 
    ('Buraco na rua', 'Rua A, 123', 'Obras', 'Problema urgente', 1, 1),
    ('Falta de medicamentos', 'Rua B, 456', 'Saúde', 'Medicamentos essenciais em falta', 2, 2);