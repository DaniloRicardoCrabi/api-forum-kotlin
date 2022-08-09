package br.com.danilocrabi.forum.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizarTopicoForm(
    @field:NotNull
    val id: Long,
    @field:Size(min = 5, max = 30)
    val titulo: String,
    val mensagem: String,
)
