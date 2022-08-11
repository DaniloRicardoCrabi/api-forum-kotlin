package br.com.danilocrabi.forum.repository;

import br.com.danilocrabi.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {

}