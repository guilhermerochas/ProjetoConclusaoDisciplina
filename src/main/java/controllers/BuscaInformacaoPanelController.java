package controllers;

import models.LocalizacaoResult;
import services.ILocalizadorService;

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

    public BuscaInformacaoPanelController(ILocalizadorService localizarSvc) {
        this.localizarSvc = localizarSvc;
    }

    public Optional<String> localizarInformacaoCEP(String textContent) {
        return localizarSvc.LocalizarInfomacaoCep(textContent);
    }
}
