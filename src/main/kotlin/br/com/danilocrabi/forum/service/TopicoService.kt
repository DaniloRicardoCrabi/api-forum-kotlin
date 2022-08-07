package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.model.Curso
import br.com.danilocrabi.forum.model.Topico
import br.com.danilocrabi.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {

    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Duvidas no Kotlin",
            mensagem = " Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Usuario (
                id = 1,
                nome = "Ana da Silva",
                email = "ana@email.com"
            ),

            )

        return Arrays.asList(topico, topico, topico);

    }
}