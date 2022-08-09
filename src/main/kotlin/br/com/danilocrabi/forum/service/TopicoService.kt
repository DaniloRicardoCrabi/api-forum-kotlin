package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.dto.AtualizarTopicoForm
import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.exception.NotFoundException
import br.com.danilocrabi.forum.mapper.TopicoFormMapper
import br.com.danilocrabi.forum.mapper.TopicoViewMapper
import br.com.danilocrabi.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList());
    }

    fun listaPeloId(id: Long): TopicoView {

        val t = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) };

        return topicoViewMapper.map(t);
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form);
        topico.id = topicos.size.toLong() + 1;
        topicos = this.topicos.plus(topico);
        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizarTopicoForm): TopicoView {

        val topico = this.topicos.stream().filter { t ->
            t.id == dto.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        val topicoAtualizado = Topico(
            id = dto.id,
            mensagem = dto.mensagem,
            titulo = dto.titulo,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        );

        topicos = topicos.minus(topico).plus(
            topicoAtualizado
        );
        return topicoViewMapper.map(topicoAtualizado);
    }

    fun deletar(id: Long) {
        val topico = this.topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        topicos = topicos.minus(topico);
    }

}