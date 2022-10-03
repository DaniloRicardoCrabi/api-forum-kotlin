package br.com.danilocrabi.forum.repository

import br.com.danilocrabi.forum.model.Roles
import org.springframework.data.jpa.repository.JpaRepository

interface RolesRepository : JpaRepository<Roles, Long> {
}