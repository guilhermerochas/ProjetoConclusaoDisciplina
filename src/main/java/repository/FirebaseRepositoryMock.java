package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import resources.LocalizacaoItemResource;
import resources.LocalizacaoResource;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class FirebaseRepositoryMock implements IRepository {
    @Override
    public List<LocalizacaoItemResource> obterLocalizacoes() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get("./firebase_response_mock.json"));
        Thread.sleep(3000);
        return new Gson().fromJson(reader, new TypeToken<List<LocalizacaoItemResource>>() {}.getType());
    }

    @Override
    public Optional<LocalizacaoResource> obterLocalizacao(String id) throws Exception {
        return Optional.of(new LocalizacaoResource()
                    .setId("178jaçp")
                    .setLocalidade("Santos")
                    .setCep("11040010")
                    .setLatitude("-23.9736663")
                    .setLongitude("-46.3105719")
                    .setTempo("chovendo")
                    .setUf("SP"));
    }

    @Override
    public Boolean criarLocalizacao(LocalizacaoResource resource) {
        if(resource == null)
            return false;
        return true;
    }
}
