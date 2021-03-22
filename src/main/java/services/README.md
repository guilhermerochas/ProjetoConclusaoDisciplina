# Consulta de CEP

## Resumo

## Etapas 
- [x]   Realizar a documentacao da consulta de CEP 
- [ ]   Realiza o retorno do codigo pronto

#### Retorno 

##### Sucesso
```json
{
  "statusCode": "200",
  "CEP": "11040-010",
  "Endereco": {
      "logradouro": "Rua Alexandre Fleming",
      "bairro": "Aparecida",
      "localidade": "Santos",
      "uf": "SP",
      "cep": "11040010"
  },
  "tempo": {
    "status": "chovendo",
    "temperatura": "23"
  },
  "googleMaps": {
    "latitude": "-23.9736663",
    "longitude": "-46.3105719"
  }
}
```

##### Falha
```json
{
  "status": "404",
  "info": {
    "message": "Não encontrado"
  }
}
```