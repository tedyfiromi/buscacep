package com.netshoes.buscacep.service.impl;

import com.netshoes.buscacep.model.Endereco;
import com.netshoes.buscacep.repository.EnderecoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoServiceImplTest {

    @InjectMocks
    private EnderecoServiceImpl service;

    @Mock
    private EnderecoRepository repositoryMock;

    @Test
    public void buscaEnderecoPorCep() {

        Endereco endereco = Endereco.builder()
                .tipoLogradouro("Rua")
                .logradouro("Maria José da Conceição")
                .cidade("São Paulo")
                .uf("SP")
                .bairro("Vila Andrade")
                .resultado(1)
                .build();

        when(repositoryMock.buscaEnderecoPorCep("05733000")).thenReturn(endereco);
        Endereco request = service.buscaEnderecoPorCep("05733000");

        assertEquals("Rua", request.getTipoLogradouro());
        assertEquals("Maria José da Conceição", request.getLogradouro());
        assertEquals("São Paulo", request.getCidade());
        assertEquals("SP", request.getUf());
        assertEquals("Vila Andrade", request.getBairro());
        assertEquals(1, request.getResultado());

        verify(repositoryMock, times(1)).buscaEnderecoPorCep("05733000");

    }

}