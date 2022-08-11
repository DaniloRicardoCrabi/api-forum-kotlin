package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.model.Curso
import br.com.danilocrabi.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getReferenceById(id);
    }
}
