# buscacep
Projeto SpringBoot BuscaCep

#Objetivo
Este projeto tem o objetivo de realizar a consulta de endereços por numero de cep. O qual deverá
ser substituído por numeros zero da direita para esquerda caso o cep seja inválido até que encontre
o endereço.

#Tecnologias utilizadas
SpringBoot, Lombok, Log4j, Dom4j, RestFull, JUnit, Mockito,
Java 11, Swagger

#Url
O projeto deve ser executado e consultado pela url:
http://localhost:8080/v1/buscacep
#paremetros
Deve ser utilizado o parametro de cep composto pelos números sem hivel conforme exemplo:
http://localhost:8080/v1/buscacep?cep=05730170

#Documentação de Serviço
A documentação de serviço REST pode ser consultada através da url:
http://localhost:8080/swagger-ui.html
