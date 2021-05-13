package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import resources.LocalizacaoItemResource;
import resources.LocalizacaoResource;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FirebaseRepositoryMock implements IRepository {
    @Override
    public List<LocalizacaoItemResource> obterLocalizacoes() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get("./firebase_response_mock.json"));
        return new Gson().fromJson(reader, new TypeToken<List<LocalizacaoItemResource>>() {}.getType());
    }

    @Override
    public LocalizacaoResource obterLocalizacao(String id) {
        return new LocalizacaoResource()
                    .setId("178jaçp")
                    .setLocalidade("Santos")
                    .setCep("11040010")
                    .setLatitude("-23.9736663")
                    .setLongitude("-46.3105719")
                    .setTempo("chovendo")
                    .setUf("SP")
                    .setImageUrl("./imgs/mock/imagem.jpg");
    }

    @Override
    public Boolean criarLocalizacao(LocalizacaoResource resource) {
        if(resource == null)
            return false;
        return true;
    }
}
