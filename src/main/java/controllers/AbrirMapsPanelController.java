package controllers;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import models.LocalizacaoResult;
import repository.FirebaseRepository;
import repository.FirebaseRepositoryMock;
import repository.IRepository;
import resources.LocalizacaoResource;
import utils.SwingUtils;

public class AbrirMapsPanelController {
    private final IRepository repository;
    private LocalizacaoResult localizacaoResult;

    public AbrirMapsPanelController(LocalizacaoResult result) throws Exception {
        this.localizacaoResult = result;
        repository = System.getenv("DEPLOY_MODE").equals("Production") ?
                new FirebaseRepository() : new FirebaseRepositoryMock();
    }

    public void AbrirMaps(LocalizacaoResult result, JFXPanel panel) {
        WebView webView = new WebView();
        panel.setScene(new Scene(webView));
        webView.getEngine().load("http://maps.google.com/maps?q=" +
                result.getGoogleMaps().getLatitude() + "," + result.getGoogleMaps().getLongitude());
    }

    public void salvarLocalizacao() throws Exception {
        LocalizacaoResource localizacao = new LocalizacaoResource()
                .setCep(localizacaoResult.getCep())
                .setLocalidade(localizacaoResult.getEndereco().getLocalidade())
                .setLatitude(localizacaoResult.getGoogleMaps().getLatitude())
                .setLongitude(localizacaoResult.getGoogleMaps().getLongitude())
                .setUf(localizacaoResult.getEndereco().getUf())
                .setTempo(localizacaoResult.getTempo().getTempo());

        if (System.getenv("DEPLOY_MODE").equals("Production")) {
            SwingUtils.takeScreenshot(String.valueOf(localizacao.hashCode()));
        }

        repository.criarLocalizacao(localizacao);
    }
}
