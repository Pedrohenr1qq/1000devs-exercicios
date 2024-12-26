create database livraria;
use livraria;

create table livros (
	id INT PRIMARY KEY AUTO_INCREMENT,
    titulo varchar(200) not null,
    autor varchar(200) not null,
	ano_publicacao int,
    preco decimal(10,2),
    data_cadastro datetime default current_timestamp
);

insert into livros (titulo, autor, ano_publicacao, preco)
values ('Dom Casmurro', 'Machado de Assis', 1899, 45.90);

insert into livros (titulo, autor, ano_publicacao, preco)
values ('Senhor dos Anéis', 'J.R.R. Tolkien', 1954, 89.90);

insert into livros (titulo, autor, ano_publicacao, preco)
values ('1984', 'George Orwell', 1949, 39.90);

select * from livros;

select * from livros where preco > 50;

select count(*) from livros;

alter table livros
add column genero varchar(200);

alter table livros
modify column autor varchar(250) not null;

delete from livros where id = 1;

select * from livros where ano_publicacao > 1950 and preco > 45;

select avg(preco) as media_valores from livros;

select * from livros where preco = (select max(preco) from livros);

select * from livros where preco = (select min(preco) from livros);

update livros
set titulo = 'titulo alterado'
where id = 2;
