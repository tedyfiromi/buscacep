package com.netshoes.buscacep.controller;

import com.netshoes.buscacep.model.Endereco;
import com.netshoes.buscacep.response.Response;
import com.netshoes.buscacep.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/buscacep")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @ApiOperation(value = "Retorna endereço por CEP")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operacao realizada com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma excessão")
    })
    @GetMapping(name = "/")
    public ResponseEntity<Response<Endereco>> buscaEnderecoPorCep(@RequestParam("cep") String cep) {

        Response<Endereco> response = new Response<Endereco>();
        Endereco endereco = service.buscaEnderecoPorCep(cep);
        if (endereco.getResultado() == 0) {
            response.setErrors("CPF Inválido");
        }

        response.setData(this.service.buscaEnderecoPorCep(cep));
        return ResponseEntity.ok(response);
    }

}
