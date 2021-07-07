# InfoCEP - Projeto de Conclusão de Disciplina

![Imagem do Projeto em execução](https://github.com/guilhermerochas/ProjetoConclusaoDisciplina/blob/main/imgs/files/infocep.PNG)

Projeto de conclusão de Disciplina feito em Java

## How to run

I have created two scripts for both *nix and windows OS.

On Macos/Linux:
```bash
    ./run.sh -d # for Production mode use './run.sh -p'
```

On Windows using Powershell:
```bash
    .\run.ps1 -d # for Production mode use '.\run.ps1 -p'
```

## Necessary settings

For using the project in Production mode you gonna need:

- Add your Firebase Admin File as ServiceKey.json
- Setup your url according the dev.env and `probably` your access key as a .env file
- setup the /cep and /pdf endpoints

## Testing the API

for testing the api, the better option is to use the `db.json` file.
To do so, you can install a npm package called json-server with the following command:

````bash
npm install -g json-server
````

and then run with:

````bash
json-server -w ./http_response_mock.json #check the server running on http://localhost:3000/data
````
