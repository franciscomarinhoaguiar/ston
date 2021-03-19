# Stone

> A API possui dois end-points(users e profit). O resource de User é usado para criar/alterar/listar/remover funcionários
> 
> O resource de profit é usado para calcular a participação de lucros
>
> ## 
> O projeto foi realizado usando Maven. IDE usada : Eclipse.
> O jersey foi escolhido para a lib de implementação da Rest API.Ele fornece suporte para APIs JAX-RS e serve como uma Implementação de Referência JAX-RS.
> ## Execução
> executar o comando mvn clean package
> 
> Depois rodar no servidor de aplicação - Tomcat por exemplo
> 
> O recurso : http://localhost:8080/profit-service-webapp/webapi/profit/10000 , o valor a ser distribuido deve ser informado /profit/{value}
> 
> O recurso : http://localhost:8080/profit-service-webapp/webapi/users/ , é responsavel pela manipulação de usuários
> 
> Formato do Json para usuários :
> 
>{
"matricula": "0007462",
"nome": "Joe Biden ", 
"area": "Financeiro",
"cargo": "Contador Pleno",
"salario_bruto": "R$ 4.200,00",
"data_de_admissao": "2018-01-03"
}

> o Resultado da api tem o formato : 
> {
  "Participacoes": [
    {
      "matricula": "0007462",
      "nome": "Joe Biden ",
      "valor_da_participação": "R$ 126.000,00"
    }
  ],
  "total_de_funcionarios": 1,
  "total_distribuido": "R$ 126.000,00",
  "total_disponibilizado": "R$ 100.000,00",
  "saldo_total_disponibilizado": "-R$ 26.000,00"
}
