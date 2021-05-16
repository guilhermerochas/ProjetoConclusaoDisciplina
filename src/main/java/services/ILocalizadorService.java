package services;

import resources.LocalizacaoItemResource;

import java.net.URI;
import java.util.Optional;

public interface ILocalizadorService {
    Optional<String> LocalizarInfomacaoCep(String cep);
    Optional<URI> imprimirLocalizacaoDeCep(LocalizacaoItemResource localizacao) throws Exception;
}
