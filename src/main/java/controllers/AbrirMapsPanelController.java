package controllers;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import models.LocalizacaoResult;

public class AbrirMapsPanelController {

    public void AbrirMaps(LocalizacaoResult result, JFXPanel panel) {
        WebView webView = new WebView();
        panel.setScene(new Scene(webView));
        webView.getEngine().load("http://maps.google.com/maps?q=" + result.getGoogleMaps().getLatitude() + "," + result.getGoogleMaps().getLongitude());
    }
}
