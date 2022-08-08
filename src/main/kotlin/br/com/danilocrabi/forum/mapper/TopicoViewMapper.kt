package br.com.danilocrabi.forum.mapper

import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao,
        )
    }
}