package services;

import com.google.gson.Gson;
import models.Cep;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class LocalizarService {
    private final String BASE_URL = "https://backend-asenjo.herokuapp.com";
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
                    .uri(URI.create(BASE_URL + "/cep"))
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .POST(BodyPublishers.ofString(cepJson))
                    .build();
            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());

            if(response.statusCode() > 300)
                return Optional.empty();

            return Optional.of(response.body());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}