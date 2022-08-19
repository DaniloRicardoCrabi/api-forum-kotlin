package br.com.danilocrabi.forum.repository

import br.com.danilocrabi.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>;
}