package repository;

import com.google.cloud.storage.Bucket;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import resources.LocalizacaoItemResource;
import resources.LocalizacaoResource;

import java.io.FileInputStream;
import java.util.List;

public class FirebaseRepository implements IRepository {
    private final Bucket bucket;

    public FirebaseRepository() throws Exception {
        FileInputStream serviceConfig = new FileInputStream("./serviceKey.json");
        FirebaseOptions opts = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceConfig))
                .setStorageBucket("infocep-cad3e.appspot.com")
                .build();
        FirebaseApp.initializeApp(opts);
        bucket = StorageClient.getInstance().bucket();
    }

    @Override
    public List<LocalizacaoItemResource> obterLocalizacoes() throws Exception {
        return null;
    }

    @Override
    public LocalizacaoResource obterLocalizacao(String id) {
        return null;
    }

    @Override
    public Boolean criarLocalizacao(LocalizacaoResource resource) {
        return null;
    }
}
