package br.com.danilocrabi.forum.repository

import br.com.danilocrabi.forum.dto.TopicoPorCategoriaDto
import br.com.danilocrabi.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>;

    @Query(value = "SELECT NEW br.com.danilocrabi.forum.dto.TopicoPorCategoriaDto(curso.categoria, count(t)) FROM Topico t join t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>
}