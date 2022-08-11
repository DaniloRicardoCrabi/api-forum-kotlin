package br.com.danilocrabi.forum.repository

import br.com.danilocrabi.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}