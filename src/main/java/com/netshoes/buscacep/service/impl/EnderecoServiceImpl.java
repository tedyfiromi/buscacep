package com.netshoes.buscacep.service.impl;

import com.netshoes.buscacep.model.Endereco;
import com.netshoes.buscacep.repository.EnderecoRepository;
import com.netshoes.buscacep.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco buscaEnderecoPorCep(final String cep) {
        return repository.buscaEnderecoPorCep(cep);
    }

}
