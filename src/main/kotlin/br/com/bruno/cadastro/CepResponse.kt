package br.com.bruno.cadastro

import br.com.bruno.SalvarResponse


class CepResponse(
    response: SalvarResponse) {

    val cep = response.cep
    val logradouro = response.logradouro
    val bairro = response.bairro
    val complemento = response.complemento
    val localidade = response.localidade
    val uf = response.uf
    val ibge = response.ibge
    val ddd = response.ddd
}