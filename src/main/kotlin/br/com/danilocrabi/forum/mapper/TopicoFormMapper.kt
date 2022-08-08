package br.com.danilocrabi.forum.mapper

import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.model.Topico
import br.com.danilocrabi.forum.service.CursoService
import br.com.danilocrabi.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
data class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) : Mapper<NovoTopicoForm, Topico> {

    override fun map(t: NovoTopicoForm): Topico {

        val novoTopico = Topico(

            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
        return novoTopico;
    };


}
