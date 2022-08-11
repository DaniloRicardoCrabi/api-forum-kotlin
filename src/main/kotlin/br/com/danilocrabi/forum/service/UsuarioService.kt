package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.model.Usuario
import br.com.danilocrabi.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getReferenceById(id);
    }
}
