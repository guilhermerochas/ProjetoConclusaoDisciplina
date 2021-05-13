package services;

import java.util.Optional;

public interface ILocalizadorService {
    Optional<String> LocalizarInfomacaoCep(String cep);
}
