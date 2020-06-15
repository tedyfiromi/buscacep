package com.netshoes.buscacep.repository;

import com.netshoes.buscacep.model.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository{

    String procuraCepValido(String cep);

    Endereco buscaEnderecoPorCep(final String cep);

}
