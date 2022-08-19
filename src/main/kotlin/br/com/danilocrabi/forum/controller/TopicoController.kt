package br.com.danilocrabi.forum.controller

import br.com.danilocrabi.forum.dto.AtualizarTopicoForm
import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.service.TopicoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController()
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {
    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(
            size = 5,
            sort = ["dataCriacao"],
            direction = Sort.Direction.DESC
        ) paginacao: Pageable //Pageable é um objeto que representa a paginação
    ): Page<TopicoView> {
        return service.listar(nomeCurso, paginacao);
    }

    @GetMapping("/{id}")
    fun listar(@PathVariable id: Long): TopicoView {
        return service.listaPeloId(id);
    }

    @PostMapping
    @Transactional
    fun cadastrar(
        @RequestBody @Valid dto: NovoTopicoForm, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(dto);
        val uri = uriBuilder.path("/topicos/${topicoView}").build().toUri();
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid dto: AtualizarTopicoForm): ResponseEntity<TopicoView> {
        val topicoAtualizado = service.atualizar(dto);
        return ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id);
    }

}