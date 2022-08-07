package br.com.danilocrabi.forum.controller

import br.com.danilocrabi.forum.model.Curso
import br.com.danilocrabi.forum.model.Topico
import br.com.danilocrabi.forum.model.Usuario
import br.com.danilocrabi.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Arrays

@RestController()
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<Topico> {
     return service.listar();
    }

}