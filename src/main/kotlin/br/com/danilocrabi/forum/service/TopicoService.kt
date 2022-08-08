package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.mapper.TopicoFormMapper
import br.com.danilocrabi.forum.mapper.TopicoViewMapper
import br.com.danilocrabi.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList());
    }

    fun listaPeloId(id: Long): TopicoView {

        val t = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get();

        return topicoViewMapper.map(t);
    }

    fun cadastrar(form: NovoTopicoForm) {


        val topico = topicoFormMapper.map(form);
        topico.id = topicos.size.toLong() + 1;
        topicos = this.topicos.plus(topico);

    }


}