package br.com.bruno.grpc

import br.com.bruno.CadastroGrpcServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class CadastroGrpcFactory(@GrpcChannel("manager")val channel: ManagedChannel){

    @Singleton
    fun cadastro() = CadastroGrpcServiceGrpc.newBlockingStub(channel)
}