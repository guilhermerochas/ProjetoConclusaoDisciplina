package services;

import com.google.gson.Gson;
import models.Cep;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.*;

public class LocalizarService {
    private final String BASE_URL = "https://backend-asenjo.herokuapp.com";
    private final HttpClient client;

    public LocalizarService(){
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
    }

    public Future<Optional<HttpResponse<String>>> GET(String url) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            CompletableFuture<Optional<HttpResponse<String>>> response  =
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                          .thenApply((result) -> Optional.of(result)).exceptionally((err) -> null);

            return response;
    }

    public Optional<String> LocalizarInfomacaoCep(String cep) {
        try {
            Cep cepModel = new Cep(cep);
            String cepJson = new Gson().toJson(cepModel);

            HttpRequest req = HttpRequest.newBuilder()
                                .uri(URI.create(BASE_URL + "/cep"))
                                .POST(BodyPublishers.ofString(cepJson))
                                .build();

            HttpResponse<String> response = client.send(req, BodyHandlers.ofString());
            return Optional.of(response.body());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}