package br.com.danilocrabi.forum.controller

import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar();
    }

    @GetMapping("/{id}")
    fun listar(@PathVariable id: Long): TopicoView {
        return service.listaPeloId(id);
    }

    @PostMapping
    fun cadastrar(@RequestBody topico: NovoTopicoForm) {
        service.cadastrar(topico);
    }

}