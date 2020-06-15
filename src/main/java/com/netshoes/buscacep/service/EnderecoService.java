package com.netshoes.buscacep.service;


import com.netshoes.buscacep.model.Endereco;

public interface EnderecoService {

    Endereco buscaEnderecoPorCep(String cep);

}
