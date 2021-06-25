package br.com.bruno.cadastro

import br.com.bruno.ListaResponse

class ListaTodosRequest(response: ListaResponse.Lista) {
    val id = response.id
    val cep = response.cep
    val logradouro = response.logradouro
    val bairro = response.bairro
    val complemento = response.complemento
    val localidade = response.localidade
    val uf = response.uf
    val ibge = response.ibge
    val ddd = response.ddd
}
