package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

public class LocalizarService {
    private int statusCode;
    private String body;

    public Optional<HttpResponse<String>> GET(String url) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.statusCode = response.statusCode();
            this.body = response.body();

            return Optional.of(response);
        } catch (Exception e){
            this.statusCode = 500;
            this.body = e.getMessage();
            return Optional.empty();
        }
    }
}