package repository;

import resources.LocalizacaoItemResource;
import resources.LocalizacaoResource;

import java.util.List;

public interface IRepository {
    List<LocalizacaoItemResource> obterLocalizacoes() throws Exception;
    LocalizacaoResource obterLocalizacao(String id);
    Boolean criarLocalizacao(LocalizacaoResource resource);
}
