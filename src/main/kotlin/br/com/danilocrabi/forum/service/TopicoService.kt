package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.dto.AtualizarTopicoForm
import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.exception.NotFoundException
import br.com.danilocrabi.forum.mapper.TopicoFormMapper
import br.com.danilocrabi.forum.mapper.TopicoViewMapper
import br.com.danilocrabi.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado"
) {

    fun listar(nomeCurso: String): List<TopicoView> {

        val topicos = if (nomeCurso == null) {
            repository.findAll();
        } else {
            repository.findByCursoNome(nomeCurso);
        }

        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listaPeloId(id: Long): TopicoView {

        val t = repository.findById(id).stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) };

        return topicoViewMapper.map(t);
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form);
        repository.save(topico);

        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizarTopicoForm): TopicoView {

        val topico = repository.findById(dto.id).stream().filter { t ->
            t.id == dto.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = dto.titulo;
        topico.mensagem = dto.mensagem;

        return topicoViewMapper.map(topico);
    }

    fun deletar(id: Long) {
        repository.deleteById(id);
    }

}