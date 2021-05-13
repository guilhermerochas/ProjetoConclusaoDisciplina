package controllers;

import models.LocalizacaoResult;
import services.ILocalizadorService;
import services.LocalizaServiceMock;
import services.LocalizarService;

import java.util.Optional;

public class BuscaInformacaoPanelController {
    private final ILocalizadorService localizarSvc;
    private static LocalizacaoResult localizacaoResult;

    public static LocalizacaoResult getLocalizacaoResult() {
        return BuscaInformacaoPanelController.localizacaoResult;
    }

    public static void setLocalizacaoResult(LocalizacaoResult result) {
        BuscaInformacaoPanelController.localizacaoResult = result;
    }

    public BuscaInformacaoPanelController() {
        this.localizarSvc = System.getenv("DEPLOY_MODE") == "Production" ? new LocalizarService() : new LocalizaServiceMock();
    }

    public Optional<String> localizarInformacaoCEP(String textContent) {
        return localizarSvc.LocalizarInfomacaoCep(textContent);
    }
}
