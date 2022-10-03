
create table usuario_roles (
     usuario_id bigint not null,
     roles_id bigint not null,
     CONSTRAINT fk_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(id),
     CONSTRAINT fk_roles FOREIGN KEY(roles_id) REFERENCES roles(id)
)