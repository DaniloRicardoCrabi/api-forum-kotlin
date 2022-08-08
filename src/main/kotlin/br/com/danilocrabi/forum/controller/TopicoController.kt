package br.com.danilocrabi.forum.controller

import br.com.danilocrabi.forum.dto.NovoTopicoDto
import br.com.danilocrabi.forum.model.Topico
import br.com.danilocrabi.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<Topico> {
        return service.listar();
    }

    @GetMapping("/{id}")
    fun listar(@PathVariable id: Long): Topico {
        return service.listaPeloId(id);
    }

    @PostMapping
    fun cadastrar(@RequestBody topico: NovoTopicoDto) {
        service.cadastrar(topico);
    }

}