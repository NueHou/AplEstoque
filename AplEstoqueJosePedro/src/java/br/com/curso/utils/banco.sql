create table TipoProduto(
    id_TipoProduto serial primary key,
    descricao varchar(200)
);

create table Produto(
    id_Produto serial primary key,
    nome_Produto varchar(200),
    ultimoPrecoPago integer,
    saldoAtual integer,
    id_TipoProduto serial,
    id_unidadeMedida serial,

    constraint fk_tipoProduto foreign key (id_TipoProduto) REFERENCES tipoProduto,
    constraint fk_unidadeMedida foreign key (id_unidadeMedida) references unidadeMedida
);

create table UnidadeMedida(
id_unidadeMedida serial primary key,
    descricao varchar(200),
    sigla varchar (3)
);

create table MovimentoEstoque(
idMovimento serial primary key,
    entradaSaida varchar(20),
    documento varchar (30),
    data varchar (20),
    quantidade integer,
    valorMovimento integer,
    id_Produto serial,
    idTipoMovimento serial,
    idFuncionario serial,

    constraint fk_produto foreign key (id_Produto)references Produto,
    constraint fk_tipoMovimento foreign key (idTipoMovimento)references tipoMovimento,
    constraint fk_funcionario foreign key (idFuncionario)references funcionario
);


create table TipoMovimento (
idTipoMovimento serial primary key,
    descricao varchar (20)
);

create table Funcionario (
idFuncionario serial primary key, 
    nomeFuncionario varchar (20)
);


/* Insert intos Funcionarios */
insert into funcionario values(1, 'José');
insert into funcionario values(2, 'Gabriela');
insert into funcionario values(3, 'Lucas');
insert into funcionario values(4, 'Roberto');

/* Insert intos Tipo Produto */

insert into tipoproduto values(1, 'alimentos');
insert into tipoproduto values(2, 'bebida');
insert into tipoproduto values(3, 'eletronico');
insert into tipoproduto values(4, 'Academia');

/* insert intos unidade medida */

Insert into unidademedida values(1, 'quilograma', 'kg');
Insert into unidademedida values(2, 'litro', 'ml');
Insert into unidademedida values(3, 'heartz', 'mhz');
Insert into unidademedida values(4, 'peso', 'kg');

/* insert into Produto */

insert into produto values(1, 'arroz', 5.50, 20.00, 1, 1);
insert into produto values(2, 'whisky', 500.00, 1000.00, 2, 2);
insert into produto values(3, 'computador i5', 2500.00, 5000.00, 3, 3);
insert into produto values(4, 'Whey', 50.00, 150.00, 4, 4);

select * from produto;

/* insert into tipo movimento */

insert into tipomovimento values (1, 'venda');

select * from tipomovimento;

/* insert into movimento estoque */

insert into movimentoestoque values (1,'saida', 'nota fiscal', '04/06/2023', 3, 60, 1, 1, 2);
insert into movimentoestoque values (2,'saida', 'nota fiscal', '04/06/2023', 4, 4000, 2, 1, 3);

select * from movimentoestoque;