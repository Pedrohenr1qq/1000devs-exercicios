-- Criacao do banco de dados
create database livraria_2;
use livraria_2;

-- Criacao das tabelas
create table  (
	id int primary key auto_increment,
    nome varchar(200) not null,
    email varchar(200) unique,
    idade int,
    data_cadastro datetime default current_timestamp
);

create table livros(
	id int primary key auto_increment,
	titulo varchar(200),
    autor varchar(200),
    preco decimal(10,2)
);

create table vendas(
	id int primary key auto_increment,
	cliente_id int,
    livro_id int,
    data_venda datetime default current_timestamp,
	quantidade int,
    foreign key (cliente_id) references clientes(id),
    foreign key (livro_id) references livros(id)
);

-- Insercao de valores nas tabelas

insert into clientes (nome, email, idade)
values ("Tiago", "tiago3oitao@gmail.com", 42);

insert into livros (titulo, autor, preco)
values ("Um curso de calculo", "Guidorizzi", 150.00);

insert into vendas (cliente_id, livro_id, quantidade)
values (2, 5, 1);

-- Consulta das tabelas
select * from clientes;
select * from livros;
select * from vendas;

-- Joins
-- Livros vendidos e clientes que compraram cada um
select livros.titulo as 'vendido', clientes.nome as 'comprador' from vendas
inner join clientes on vendas.cliente_id = clientes.id
inner join livros on vendas.livro_id = livros.id;
                             
-- Todos os clientes, incluindo os que não compraram nada
select clientes.nome as 'clientes', livros.titulo as 'livros' from vendas
right join clientes on vendas.cliente_id = clientes.id
left join livros on vendas.livro_id = livros.id;

-- Livros por  cada  Clientes
select clientes.nome as 'clientes', count(vendas.livro_id) as quant_livros from vendas
join clientes on vendas.cliente_id = clientes.id
group by clientes.nome;

-- Livros mais vendidos
select livros.titulo as "livros", count(vendas.cliente_id) as qt_vendido from vendas
join livros on vendas.livro_id = livros.id
group by livros.titulo
order by qt_vendido desc;

-- Clientes com mais de R$100 em compras
select clientes.nome as "Cliente", sum(livros.preco) as 'Valor Pago' from vendas
join clientes on vendas.cliente_id = clientes.id
join livros on vendas.livro_id = livros.id
group by clientes.nome;
