package br.com.bruno.cadastro

import br.com.bruno.*
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller("/api/v1/cadastro")
class CadastroController(private val cadastroService : CadastroGrpcServiceGrpc.CadastroGrpcServiceBlockingStub) {


    @Post("/{cep}" )
    @Secured(SecurityRule.IS_AUTHENTICATED)
    fun cadastro(@PathVariable(name = "cep") cep: String) = cadastroService.salvar(
        SalvarRequest.newBuilder()
        .setCep(cep)
        .build()).let {
        HttpResponse.created(CepResponse(it))
    }

    @Delete("{id}")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    fun deletar(@PathVariable(name = "id") id: Long) = cadastroService.deletar(
        DeletarRequest.newBuilder()
            .setId(id)
            .build()).let {
                HttpResponse.ok(DeleteResponse(it))
            }

    @Get("{id}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    fun consultar(@PathVariable(name = "id") id: Long) = cadastroService.consultar(
        ConsultarRequest.newBuilder()
            .setId(id)
            .build()).let {
                HttpResponse.ok(ConsultaCepResponse(it))
    }

    @Get
    @Secured(SecurityRule.IS_ANONYMOUS)
    fun listarTodos(): Any =  cadastroService.listar(
          ListaRequest.newBuilder().build()).listaList.map { ListaTodosRequest(it) }
            .let { return HttpResponse.ok(it) }


}