package services;

import java.util.Optional;

public class LocalizaServiceMock implements ILocalizadorService{

    public Optional<String> LocalizarInfomacaoCep(String cep) {
        String data = "{\n" +
                "  \"CEP\": \"11040-010\",\n" +
                "  \"Endereco\": {\n" +
                "    \"logradouro\": \"Rua Alexandre Fleming\",\n" +
                "    \"bairro\": \"Aparecida\",\n" +
                "    \"localidade\": \"Santos\",\n" +
                "    \"uf\": \"SP\",\n" +
                "    \"cep\": \"11040010\"\n" +
                "  },\n" +
                "  \"tempo\": {\n" +
                "    \"status\": \"chovendo\",\n" +
                "    \"temperatura\": \"23 graus\"\n" +
                "  },\n" +
                "  \"googleMaps\": {\n" +
                "    \"latitude\": \"-23.9736663\",\n" +
                "    \"longitude\": \"-46.3105719\"\n" +
                "  }\n" +
                "}";

        return Optional.of(data);
    }
}
