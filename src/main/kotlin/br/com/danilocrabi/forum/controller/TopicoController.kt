package br.com.danilocrabi.forum.controller

import br.com.danilocrabi.forum.dto.AtualizarTopicoForm
import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm) {
        service.cadastrar(dto);
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizarTopicoForm) {
        service.atualizar(dto);
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        service.deletar(id);
    }

}