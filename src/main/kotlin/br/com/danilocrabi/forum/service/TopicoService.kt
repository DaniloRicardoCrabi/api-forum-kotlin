package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.dto.NovoTopicoForm
import br.com.danilocrabi.forum.dto.TopicoView
import br.com.danilocrabi.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService
) {

    fun listar(): List<TopicoView> {


        return topicos.stream().map { t ->
            TopicoView(
                id = t.id,
                titulo = t.titulo,
                mensagem = t.mensagem,
                status = t.status,
                dataCriacao = t.dataCriacao,
            )
        }.collect(Collectors.toList());

    }

    fun listaPeloId(id: Long): TopicoView {

        val t = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get();

        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao,
        )

    }

    fun cadastrar(dto: NovoTopicoForm) {

        topicos = this.topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = usuarioService.buscarPorId(dto.idAutor)
            )
        );
        System.out.println("Size : " + topicos.size);
    }


}