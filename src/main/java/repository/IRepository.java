package repository;

import resources.LocalizacaoItemResource;
import resources.LocalizacaoResource;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface IRepository {
    List<LocalizacaoItemResource> obterLocalizacoes() throws Exception;
    Optional<LocalizacaoResource> obterLocalizacao(String id) throws Exception;
    Boolean criarLocalizacao(LocalizacaoResource resource);
}
