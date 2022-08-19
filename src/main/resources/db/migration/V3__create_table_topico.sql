create table topico(
    id SERIAL PRIMARY KEY,
    titulo varchar(50) not null,
    mensagem varchar(50) not null,
    data_criacao timestamp not null,
    status varchar(20) not null,
    curso_id bigint not null,
    autor_id bigint not null,
    CONSTRAINT fk_topico_curso FOREIGN KEY(curso_id) REFERENCES curso(id),
    CONSTRAINT fk_topico_autor FOREIGN KEY(autor_id) REFERENCES usuario(id)
);