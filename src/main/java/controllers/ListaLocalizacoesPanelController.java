package controllers;

import repository.FirebaseRepository;
import repository.FirebaseRepositoryMock;
import repository.IRepository;
import resources.LocalizacaoItemResource;
import services.ILocalizadorService;
import services.LocalizaServiceMock;
import services.LocalizarService;

import javax.swing.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListaLocalizacoesPanelController {
    private final DefaultListModel<String> listModel;
    private final IRepository firebaseRepository;
    private List<LocalizacaoItemResource> localizacoes;
    private final ILocalizadorService service;

    public ListaLocalizacoesPanelController() throws Exception {
        listModel = new DefaultListModel<>();
        service = System.getenv("DEPLOY_MODE").equals("Production") ? new LocalizarService() : new LocalizaServiceMock();
        firebaseRepository = System.getenv("DEPLOY_MODE").equals("Production") ? new FirebaseRepository() : new FirebaseRepositoryMock();
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public IRepository getFirebaseRepository() {
        return firebaseRepository;
    }

    public LocalizacaoItemResource obterLocalizacao(int index) {
        return this.localizacoes.get(index);
    }

    public void recarregarLista() throws Exception {
        this.listModel.clear();
        this.localizacoes = firebaseRepository.obterLocalizacoes();
        List<String> data = localizacoes.stream().map(e -> "  " + e.toString())
                .collect(Collectors.toList());
        data.forEach(this.listModel::addElement);
    }

    public Optional<URI> ImprimirLocalizacaoCep(int index) throws Exception {
        return service.imprimirLocalizacaoDeCep(localizacoes.get(index));
    }
}
