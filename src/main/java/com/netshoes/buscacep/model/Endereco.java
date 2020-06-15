package com.netshoes.buscacep.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Endereco {

    @ApiModelProperty(value = "Bairro")
    private String bairro = null;
    @ApiModelProperty(value = "Endereco")
    private String cidade = null;
    @ApiModelProperty(value = "Logradouro")
    private String logradouro = null;
    @ApiModelProperty(value = "Tipo Logradouro")
    private String tipoLogradouro = null;
    @ApiModelProperty(value = "Uf")
    private String uf = null;
    @ApiModelProperty(value = "Resultado da operação")
    private int resultado = 0;

    public Endereco() {}

}
