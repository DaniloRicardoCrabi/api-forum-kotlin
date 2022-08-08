package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Danilo",
            email = "danilo@gmail.com"
        )
        usuarios = Arrays.asList(usuario);
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter({ c ->
            c.id == id
        }).findFirst().get();
    }
}
