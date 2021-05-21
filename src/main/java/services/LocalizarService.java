package services;

import com.google.gson.Gson;
import models.Cep;
import models.LocalizacaoResult;
import resources.LocalizacaoItemResource;
import resources.PdfUploadResource;
import utils.OSUtils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Optional;

public class LocalizarService implements ILocalizadorService {
    private final HttpClient client;

    public LocalizarService() {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    public Optional<String> LocalizarInfomacaoCep(String cep) {
        try {
            Cep cepModel = new Cep(cep);
            String cepJson = new Gson().toJson(cepModel);
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(OSUtils.getEnvVariable("LOCALIZACAO_BASE_URL").orElseThrow() + "/cep"))
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .header("Authorization", OSUtils.getEnvVariable("AUTH_TOKEN").orElseThrow())
                    .POST(BodyPublishers.ofString(cepJson))
                    .build();
            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());

            if (response.statusCode() > 300)
                return Optional.empty();

            return Optional.of(response.body());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<URI> imprimirLocalizacaoDeCep(LocalizacaoItemResource localizacao) throws Exception {
        try {
            if(localizacao == null)
                return Optional.empty();

            HttpRequest req = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(URI.create(OSUtils.getEnvVariable("LOCALIZACAO_BASE_URL").orElseThrow() + "/pdf?chave=" + localizacao.getId()))
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .header("Authorization", OSUtils.getEnvVariable("AUTH_TOKEN").orElseThrow())
                    .build();

            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());

            if (response.statusCode() > 300)
                return Optional.empty();

            PdfUploadResource pdfUrl = new Gson().fromJson(response.body(), PdfUploadResource.class);
            System.out.println(response.body());
            System.out.println(pdfUrl.getUrl());
            pdfUrl.setUrl(OSUtils.getEnvVariable("LOCALIZACAO_BASE_URL").orElseThrow() + "/" + pdfUrl.getUrl());

            return Optional.of(new URI(pdfUrl.getUrl()));
        } catch (Exception e){
            return Optional.empty();
        }
    }
}