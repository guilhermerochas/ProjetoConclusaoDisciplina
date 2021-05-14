# ProjetoConclusaoDisciplina

Projeto de conclusão de Disciplina feito em Java

## How to run

I have created two for both *nix and windows OS with the following scripts.

On Macos/Linux:
```bash
    ./run.sh -d # for Production mode use './run -p'
```

On Windows using Powershell:
```bash
    .\run.ps1 -d # for Production mode use '.\run.ps1 -p'
```

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
