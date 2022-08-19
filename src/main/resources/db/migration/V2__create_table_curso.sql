create table curso(
    id bigint SERIAL PRIMARY KEY,
    nome varchar(50) not null,
    categoria varchar(50) not null,
    primary key(id)
);
