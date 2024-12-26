create database biblioteca;
use biblioteca;

create table professores(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome_completo VARCHAR(150) NOT NULL,
    cpf VARCHAR(150) UNIQUE,
    data_nascimento DATE,
    email_institucional VARCHAR(100) UNIQUE,
    telefone VARCHAR(15),
    area_atuacao VARCHAR(100),
    titulacao ENUM('Graduação', 'Mestrado', 'Doutorado'),
    data_admissao DATE,
    registro_profissional VARCHAR(300),
    status ENUM('Ativo', 'Inativo')
);

create table autores(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome_completo VARCHAR(150) NOT NULL,
    nome_artistico VARCHAR(100) NULL,
    nacionalidade VARCHAR(50),
    data_nascimento DATE,
    biografia LONGTEXT,
    email_contato varchar(100),
    area_principal varchar(100),
    status ENUM('Ativo', 'Inativo')    
);


create table categorias(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome_categoria VARCHAR(100) NOT NULL,
    codigo_categoria VARCHAR(20) UNIQUE,
    descricao LONGTEXT,
	categoria_pai_id INT NULL,
    status ENUM('Ativo', 'Inativo')    
);

CREATE TABLE editoras(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome_editora VARCHAR(150) NOT NULL,
    cnpj VARCHAR(18) UNIQUE,
    razao_social VARCHAR(200),
    endereco TEXT,
    telefone_comercial VARCHAR(15),
    email_comercial VARCHAR(100),
    site VARCHAR(100),
    nome_contato VARCHAR(100),
    telefone_contato VARCHAR(15),
    data_cadastro DATE,
    status ENUM('Ativo', 'Inativo')
);

CREATE TABLE livros(
	id INT PRIMARY KEY AUTO_INCREMENT,
	titulo VARCHAR(200) NOT NULL,
    subtitulo VARCHAR(200) NULL,
    editora_id int,
    ano_publicacao DATE,
	edicao VARCHAR(50),
    numero_paginas INT,
    sinopse LONGTEXT,
    capa_url VARCHAR(255),
    preco DECIMAL(10,2),
    quantidade_estoque INT,
	status ENUM('Ativo', 'Inativo'),
	data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (editora_id) REFERENCES editoras(id)
);

CREATE TABLE livro_autores(
	id INT PRIMARY KEY AUTO_INCREMENT,
	livro_id INT,
    autor_id INT,
    
    FOREIGN KEY (livro_id) REFERENCES livros(id),
    FOREIGN KEY (autor_id) REFERENCES autores(id)
);	

CREATE TABLE livro_categorias(
	id INT PRIMARY KEY AUTO_INCREMENT,
	livro_id INT,
    categoria_id INT,
    
    FOREIGN KEY (livro_id) REFERENCES livros(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

show tables;
