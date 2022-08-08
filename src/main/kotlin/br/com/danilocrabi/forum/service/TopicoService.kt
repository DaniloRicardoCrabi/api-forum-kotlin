package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.dto.NovoTopicoDto
import br.com.danilocrabi.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService
) {

    fun listar(): List<Topico> {

        return topicos;

    }

    fun listaPeloId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get();
    }

    fun cadastrar(dto: NovoTopicoDto) {

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