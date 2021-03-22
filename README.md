# ProjetoConclusaoDisciplina

Projeto de conclusão de Disciplina feito em Java

## How to run

Use the following commands in the project folder:

```bash
mvn clean install #or ./mvnw clean install
java -jar ./target/{project_name}.jar
```

## Testing the API

for testing the api, the better option is to use the `db.json` file.
To do so, you can install a npm package called json-server with the following command:

````bash
npm install -g json-server
````

and then run with:

````bash
json-server -w ./db.json #check the server running on http://localhost:3000/data
````