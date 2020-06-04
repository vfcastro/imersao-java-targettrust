CREATE TABLE unidade (
	id serial NOT NULL,
	nome varchar(100) NOT NULL,
	endereco varchar(150) NOT NULL,
    primary key (id)
);

create table TB_CLIENTE (
    id serial NOT NULL,
    nro_cpf VARCHAR(14) not null,
    txt_nome varchar(255),
    primary key (id));
